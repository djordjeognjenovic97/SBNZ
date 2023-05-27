package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import com.ftn.model.AccumulateFragrance;
import com.ftn.model.DayNight;
import com.ftn.model.Fragrance;
import com.ftn.model.FragranceQuery;
import com.ftn.model.MidClss;
import com.ftn.model.Person;
import com.ftn.model.PersonQuery;
import com.ftn.model.enums.Concentration;
import com.ftn.model.enums.Cost;
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
        MidClss mc = new MidClss();
        ksession.insert(f);
        ksession.insert(dn);
        ksession.insert(mc);
        ksession.getAgenda().getAgendaGroup("person_fragrance_rules").setFocus();
        ksession.fireAllRules();
        assertEquals(mc.getLongevity(), Longevity.SHORT);

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
        MidClss mc = new MidClss();
        ksession.insert(f);
        ksession.insert(dn);
        ksession.insert(mc);
        ksession.getAgenda().getAgendaGroup("person_fragrance_rules").setFocus();
        ksession.fireAllRules();
        assertEquals(mc.getLongevity(), Longevity.LONG);

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
        MidClss mc = new MidClss();
        ksession.insert(f);
        ksession.insert(dn);
        ksession.insert(mc);
        ksession.getAgenda().getAgendaGroup("person_fragrance_rules").setFocus();
        ksession.fireAllRules();
        assertEquals(mc.getLongevity(), Longevity.MEDIUM);

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
        MidClss mc = new MidClss();
        ksession.insert(f);
        ksession.insert(dn);
        ksession.insert(mc);
        ksession.getAgenda().getAgendaGroup("person_fragrance_rules").setFocus();
        ksession.fireAllRules();
        assertEquals(mc.getLongevity(), Longevity.LONG);

        ksession.dispose();
        
    }

    @Test
    public void testProjectionStrongYoungAdultParty() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);

        PersonQuery q = new PersonQuery(20, Occasion.PARTY);
        ksession.setGlobal("pq", q);
        Person p = new Person();
        ksession.insert(p);
        Fragrance f = new Fragrance(Projection.STRONG, 0);
        ksession.insert(f);

        ksession.getAgenda().getAgendaGroup("person_rules").setFocus();
        ksession.fireAllRules();

        assertEquals(f.getScore(), 5);

        ksession.dispose();
        
    }

    @Test
    public void testProjectionModerateYoungAdultEveryday() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);

        PersonQuery q = new PersonQuery(23, Occasion.EVERYDAY);
        ksession.setGlobal("pq", q);
        Person p = new Person();
        ksession.insert(p);
        Fragrance f = new Fragrance(Projection.MODERATE, 0);
        ksession.insert(f);

        ksession.getAgenda().getAgendaGroup("person_rules").setFocus();
        ksession.fireAllRules();

        assertEquals(f.getScore(), 5);

        ksession.dispose();
        
    }

    @Test
    public void testProjectionIntimateAdultOffice() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);

        PersonQuery q = new PersonQuery(40, Occasion.OFFICE);
        ksession.setGlobal("pq", q);
        Person p = new Person();
        ksession.insert(p);
        Fragrance f = new Fragrance(Projection.INTIMATE, 0);
        ksession.insert(f);

        ksession.getAgenda().getAgendaGroup("person_rules").setFocus();
        ksession.fireAllRules();

        assertEquals(f.getScore(), 5);

        ksession.dispose();
        
    }

    @Test
    public void testCostMedium() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);

        FragranceQuery q = new FragranceQuery(7569);
        ksession.setGlobal("fq", q);
        Fragrance f = new Fragrance();
        MidClss mc = new MidClss();
        ksession.insert(f);
        ksession.insert(mc);
        ksession.getAgenda().getAgendaGroup("person_fragrance_rules").setFocus();
        ksession.fireAllRules();

        assertEquals(mc.getCostTier(), Cost.MEDIUM);

        ksession.dispose();
        
    }

    @Test
    public void testConcentrationThirdLevel() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);

        PersonQuery q = new PersonQuery(Occasion.EVERYDAY);
        ksession.setGlobal("pq", q);
        FragranceQuery fq = new FragranceQuery(Season.SUMMER, 4000);
        ksession.setGlobal("fq", fq);
        Fragrance f = new Fragrance(Concentration.EDC, 0);
        DayNight dn = new DayNight();
        MidClss mc = new MidClss();
        ksession.insert(f);
        ksession.insert(dn);
        ksession.insert(mc);
        ksession.getAgenda().getAgendaGroup("person_fragrance_rules").setFocus();
        ksession.fireAllRules();

        assertEquals(f.getScore(), 5);

        ksession.dispose();
        
    }

    @Test
    public void testConcentrationThirdLevel2() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);

        PersonQuery q = new PersonQuery(Occasion.PARTY);
        ksession.setGlobal("pq", q);
        FragranceQuery fq = new FragranceQuery(Season.AUTUMN, 20000);
        ksession.setGlobal("fq", fq);
        Fragrance f = new Fragrance(Concentration.PARFUM, 0);
        DayNight dn = new DayNight();
        MidClss mc = new MidClss();
        ksession.insert(f);
        ksession.insert(dn);
        ksession.insert(mc);
        ksession.getAgenda().getAgendaGroup("person_fragrance_rules").setFocus();
        ksession.fireAllRules();

        assertEquals(f.getScore(), 5);

        ksession.dispose();
        
    }

    @Test
    public void testAccumulate() {

        KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession(ksessionName);

        Fragrance f1 = new Fragrance();
        f1.setDesigner("Dior");
        f1.setPrice(500);
        Fragrance f2 = new Fragrance();
        f2.setDesigner("Dior");
        f2.setPrice(100);
        Fragrance f3 = new Fragrance();
        f3.setDesigner("Chanel");
        f3.setPrice(5);
        AccumulateFragrance af = new AccumulateFragrance(); 

        af.setFragrances(new ArrayList<>());
        af.getFragrances().add(f1);
        af.getFragrances().add(f2);
        af.getFragrances().add(f3);
        af.setBrandName("Dior");
        ksession.insert(af);
        ksession.getAgenda().getAgendaGroup("acc_rule").setFocus();
        ksession.fireAllRules();

        assertEquals(af.getMinPrice(), 100);
        assertEquals(af.getMaxPrice(), 500);
        assertEquals(af.getAvgPrice(), 300);

        ksession.dispose();
        
    }
}
