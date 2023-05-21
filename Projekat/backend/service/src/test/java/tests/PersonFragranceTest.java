package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ftn.model.DayNight;
import com.ftn.model.Fragrance;
import com.ftn.model.FragranceQuery;
import com.ftn.model.Person;
import com.ftn.model.PersonQuery;
import com.ftn.model.enums.DayOrNight;
import com.ftn.model.enums.Gender;
import com.ftn.model.enums.Longevity;
import com.ftn.model.enums.Occasion;
import com.ftn.model.enums.Projection;
import com.ftn.model.enums.Season;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class PersonFragranceTest {
    protected final String ksessionName = "ksession-rules";
    
    @Test
    public void testGenderScore() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);
        ksession.getAgenda().getAgendaGroup("person_fragrance_rules").setFocus();

        PersonQuery q = new PersonQuery(Gender.MALE);
        ksession.setGlobal("pq", q);
        Fragrance f = new Fragrance(Gender.MALE, 0);
        ksession.insert(f);

        ksession.getAgenda().getAgendaGroup("person_fragrance_rules").setFocus();
        ksession.fireAllRules();

        assertEquals(f.getScore(), 30);

        ksession.dispose();
        
    }

    @Test
    public void testUnisexScore() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);
        ksession.getAgenda().getAgendaGroup("person_fragrance_rules").setFocus();

        PersonQuery q = new PersonQuery(Gender.UNISEX);
        ksession.setGlobal("pq", q);
        Fragrance f1 = new Fragrance(Gender.MALE, 0);
        ksession.insert(f1);
        Fragrance f2 = new Fragrance(Gender.UNISEX, 0);
        ksession.insert(f2);

        ksession.getAgenda().getAgendaGroup("person_fragrance_rules").setFocus();
        ksession.fireAllRules();

        assertEquals(f1.getScore(), 15);
        assertEquals(f2.getScore(), 30);

        ksession.dispose();
        
    }

    @Test
    public void testYoungAdultMaleScoreRule() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);

        PersonQuery q = new PersonQuery(22, Gender.MALE);
        ksession.setGlobal("pq", q);
        Person p = new Person();
        p.setGender(q.getGender());
        ksession.insert(p);
        Fragrance f = new Fragrance("Versace", 0);
        ksession.insert(f);
        ksession.getAgenda().getAgendaGroup("person_rules").setFocus();

        ksession.fireAllRules();

        assertEquals(f.getScore(), 15);

        ksession.dispose();
        
    }

    @Test
    public void testYoungAdultFemaleScoreRule() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);

        PersonQuery q = new PersonQuery(21, Gender.FEMALE);
        ksession.setGlobal("pq", q);
        Person p = new Person();
        p.setGender(q.getGender());
        ksession.insert(p);
        Fragrance f = new Fragrance("Armani", 0);
        ksession.insert(f);
        ksession.getAgenda().getAgendaGroup("person_rules").setFocus();

        ksession.fireAllRules();

        assertEquals(f.getScore(), 15);

        ksession.dispose();
        
    }

    @Test
    public void testAdultMaleScoreRule() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);

        PersonQuery q = new PersonQuery(35, Gender.MALE);
        ksession.setGlobal("pq", q);
        Person p = new Person();
        p.setGender(q.getGender());
        ksession.insert(p);
        Fragrance f = new Fragrance("CHAnel", 0);
        ksession.insert(f);
        ksession.getAgenda().getAgendaGroup("person_rules").setFocus();

        ksession.fireAllRules();

        assertEquals(f.getScore(), 15);

        ksession.dispose();
        
    }

    @Test
    public void testOlderAdultMaleScoreRule() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);

        PersonQuery q = new PersonQuery(60, Gender.MALE);
        ksession.setGlobal("pq", q);
        Person p = new Person();
        p.setGender(q.getGender());
        ksession.insert(p);
        Fragrance f = new Fragrance("guerlain", 0);
        ksession.insert(f);
        ksession.getAgenda().getAgendaGroup("person_rules").setFocus();

        ksession.fireAllRules();

        assertEquals(f.getScore(), 15);

        ksession.dispose();
        
    }

    @Test
    public void testAdultFemaleScoreRule() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);

        PersonQuery q = new PersonQuery(29, Gender.FEMALE);
        ksession.setGlobal("pq", q);
        Person p = new Person();
        p.setGender(q.getGender());
        ksession.insert(p);
        Fragrance f = new Fragrance("LANCOME", 0);
        ksession.insert(f);
        ksession.getAgenda().getAgendaGroup("person_rules").setFocus();

        ksession.fireAllRules();

        assertEquals(f.getScore(), 15);

        ksession.dispose();
        
    }

    @Test
    public void testDayAndNight() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);

        PersonQuery q = new PersonQuery(Occasion.DATE);
        ksession.setGlobal("pq", q);
        Fragrance f1 = new Fragrance();
        DayNight dn = new DayNight();
        ksession.insert(f1);
        ksession.insert(dn);
        ksession.getAgenda().getAgendaGroup("person_fragrance_rules").setFocus();
        ksession.fireAllRules();
        assertEquals(dn.getValue(), DayOrNight.NIGHT);

        PersonQuery q2 = new PersonQuery(Occasion.EVERYDAY);
        ksession.setGlobal("pq", q2);
        Fragrance f2 = new Fragrance();
        ksession.insert(f2);
        ksession.getAgenda().getAgendaGroup("person_fragrance_rules").setFocus();
        ksession.fireAllRules();
        assertEquals(dn.getValue(), DayOrNight.DAY);

        ksession.dispose();
        
    }

    @Test
    public void testLongetivityDaySummer() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);

        PersonQuery q = new PersonQuery(Occasion.EVERYDAY);
        ksession.setGlobal("pq", q);
        FragranceQuery fq = new FragranceQuery(Season.SUMMER);
        ksession.setGlobal("fq", fq);
        Fragrance f = new Fragrance();
        DayNight dn = new DayNight();
        ksession.insert(f);
        ksession.insert(dn);
        ksession.getAgenda().getAgendaGroup("person_fragrance_rules").setFocus();
        ksession.fireAllRules();
        assertEquals(f.getLongevity(), Longevity.SHORT);

        ksession.dispose();
        
    }

    @Test
    public void testLongetivityNightAutumn() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);

        PersonQuery q = new PersonQuery(Occasion.DATE);
        ksession.setGlobal("pq", q);
        FragranceQuery fq = new FragranceQuery(Season.AUTUMN);
        ksession.setGlobal("fq", fq);
        Fragrance f = new Fragrance();
        DayNight dn = new DayNight();
        ksession.insert(f);
        ksession.insert(dn);
        ksession.getAgenda().getAgendaGroup("person_fragrance_rules").setFocus();
        ksession.fireAllRules();
        assertEquals(f.getLongevity(), Longevity.LONG);

        ksession.dispose();
        
    }

    @Test
    public void testLongetivityDaySpring() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);

        PersonQuery q = new PersonQuery(Occasion.OFFICE);
        ksession.setGlobal("pq", q);
        FragranceQuery fq = new FragranceQuery(Season.SPRING);
        ksession.setGlobal("fq", fq);
        Fragrance f = new Fragrance();
        DayNight dn = new DayNight();
        ksession.insert(f);
        ksession.insert(dn);
        ksession.getAgenda().getAgendaGroup("person_fragrance_rules").setFocus();
        ksession.fireAllRules();
        assertEquals(f.getLongevity(), Longevity.MEDIUM);

        ksession.dispose();
        
    }

    @Test
    public void testLongetivityDayWinter() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);

        PersonQuery q = new PersonQuery(Occasion.EVERYDAY);
        ksession.setGlobal("pq", q);
        FragranceQuery fq = new FragranceQuery(Season.WINTER);
        ksession.setGlobal("fq", fq);
        Fragrance f = new Fragrance();
        DayNight dn = new DayNight();
        ksession.insert(f);
        ksession.insert(dn);
        ksession.getAgenda().getAgendaGroup("person_fragrance_rules").setFocus();
        ksession.fireAllRules();
        assertEquals(f.getLongevity(), Longevity.LONG);

        ksession.dispose();
        
    }

    @Test
    public void testProjectionYoungAdultParty() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);

        PersonQuery q = new PersonQuery(20, Occasion.PARTY);
        ksession.setGlobal("pq", q);
        Person p = new Person();
        ksession.insert(p);
        Fragrance f = new Fragrance();
        ksession.insert(f);

        ksession.getAgenda().getAgendaGroup("person_rules").setFocus();
        ksession.fireAllRules();

        assertEquals(f.getProjection(), Projection.STRONG);

        ksession.dispose();
        
    }

    @Test
    public void testProjectionYoungAdultEveryday() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);

        PersonQuery q = new PersonQuery(23, Occasion.EVERYDAY);
        ksession.setGlobal("pq", q);
        Person p = new Person();
        ksession.insert(p);
        Fragrance f = new Fragrance();
        ksession.insert(f);

        ksession.getAgenda().getAgendaGroup("person_rules").setFocus();
        ksession.fireAllRules();

        assertEquals(f.getProjection(), Projection.MODERATE);

        ksession.dispose();
        
    }

    @Test
    public void testProjectionAdultOffice() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);

        PersonQuery q = new PersonQuery(40, Occasion.OFFICE);
        ksession.setGlobal("pq", q);
        Person p = new Person();
        ksession.insert(p);
        Fragrance f = new Fragrance();
        ksession.insert(f);

        ksession.getAgenda().getAgendaGroup("person_rules").setFocus();
        ksession.fireAllRules();

        assertEquals(f.getProjection(), Projection.INTIMATE);

        ksession.dispose();
        
    }
}
