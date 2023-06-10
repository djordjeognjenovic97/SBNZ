package com.ftn.service.services;

import java.util.Collections;
import java.util.List;

import com.ftn.model.AccumulateFragrance;
import com.ftn.model.DayNight;
import com.ftn.model.Fragrance;
import com.ftn.model.FragranceQuery;
import com.ftn.model.MidClss;
import com.ftn.model.Person;
import com.ftn.model.PersonQuery;
import com.ftn.service.dto.AccumulateFragranceDTO;
import com.ftn.service.dto.QueryDTO;
import com.ftn.service.repository.FragranceRepository;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FragranceService {
    @Autowired
    private FragranceRepository fragranceRepository;

    @Autowired
    private KieContainer kieContainer;

    protected final String ksessionName = "ksession-rules";

    public List<Fragrance> findAll() {
        return fragranceRepository.findAll();
    }

    public List<Fragrance> queryFragrances(QueryDTO queryDTO) {
        
        KieSession ksession = kieContainer.newKieSession(ksessionName);

        List<Fragrance> frags = findAll();

        PersonQuery q = queryDTO.getPersonQuery();
        ksession.setGlobal("pq", q);
        FragranceQuery fq = queryDTO.getFragranceQuery();
        ksession.setGlobal("fq", fq);
        Person p = new Person();
        p.setGender(q.getGender());
        DayNight dn = new DayNight();
        MidClss mc = new MidClss();
        ksession.insert(p);
        ksession.insert(dn);
        ksession.insert(mc);

        frags.forEach((n) -> { ksession.insert(n); });

        ksession.getAgenda().getAgendaGroup("person_rules").setFocus();
        ksession.fireAllRules();
        ksession.getAgenda().getAgendaGroup("fragrance_rules").setFocus();
        ksession.fireAllRules();
        ksession.getAgenda().getAgendaGroup("person_fragrance_rules").setFocus();
        ksession.fireAllRules();

        ksession.dispose();
        
        Collections.sort(frags, Collections.reverseOrder());
        return frags.subList(0, 3);
    }

    public AccumulateFragranceDTO getStats(String brandName) {
        KieSession ksession = kieContainer.newKieSession(ksessionName);

        AccumulateFragrance af = new AccumulateFragrance(); 

        af.setFragrances(findAll());
        af.setBrandName(brandName);
        ksession.insert(af);
        ksession.getAgenda().getAgendaGroup("acc_rule").setFocus();
        ksession.fireAllRules();

        ksession.dispose();

        return new AccumulateFragranceDTO(af.getBrandName(), af.getMinPrice(), af.getMaxPrice(), af.getAvgPrice());
    }
}
