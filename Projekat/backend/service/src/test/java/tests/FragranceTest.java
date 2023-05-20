package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ftn.model.Fragrance;
import com.ftn.model.FragranceQuery;
import com.ftn.model.enums.Family;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class FragranceTest {

    protected final String ksessionName = "ksession-rules";
    
    @Test
    public void testDesignerScore() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);
        ksession.getAgenda().getAgendaGroup("fragrance_rules").setFocus();

        FragranceQuery q = new FragranceQuery("Versace");
        ksession.setGlobal("fq", q);
        Fragrance f = new Fragrance("Versace", 0);
        ksession.insert(f);

        ksession.getAgenda().getAgendaGroup("fragrance_rules").setFocus();
        ksession.fireAllRules();

        assertEquals(f.getScore(), 15);

        ksession.dispose();
        
    }

    @Test
    public void testDesignerAndFamilyScore() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);
        ksession.getAgenda().getAgendaGroup("fragrance_rules").setFocus();

        FragranceQuery q = new FragranceQuery("Chanel", Family.AQUATIC);
        ksession.setGlobal("fq", q);
        Fragrance f = new Fragrance("Chanel", Family.AQUATIC, 0);
        ksession.insert(f);

        ksession.getAgenda().getAgendaGroup("fragrance_rules").setFocus();
        ksession.fireAllRules();

        assertEquals(f.getScore(), 25);

        ksession.dispose();
        
    }
    
}
