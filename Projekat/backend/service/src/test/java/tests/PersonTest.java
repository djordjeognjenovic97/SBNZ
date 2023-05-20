package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ftn.model.Person;
import com.ftn.model.PersonQuery;
import com.ftn.model.enums.AgeRange;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class PersonTest {
    protected final String ksessionName = "ksession-rules";
    
    @Test
    public void testPersonChild() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);
        //ksession.getAgenda().getAgendaGroup("person_rules").setFocus();

        PersonQuery q = new PersonQuery(12);
        ksession.setGlobal("pq", q);
        Person p = new Person();
        ksession.insert(p);

        ksession.getAgenda().getAgendaGroup("person_rules").setFocus();
        ksession.fireAllRules();

        assertEquals(p.getAgeRange(), AgeRange.CHILD);

        ksession.dispose();
        
    }
}
