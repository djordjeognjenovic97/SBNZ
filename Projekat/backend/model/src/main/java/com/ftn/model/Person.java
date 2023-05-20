package com.ftn.model;

import com.ftn.model.enums.AgeRange;
import com.ftn.model.enums.Gender;

public class Person {
    private AgeRange ageRange;
    private String occasion;
    private Gender gender;

    public Person() {
    }

    public Person(AgeRange ageRange, Gender gender) {
        this.ageRange = ageRange;
        this.gender = gender;
    }

    public Person(AgeRange ageRange, String occasion) {
        this.ageRange = ageRange;
        this.occasion = occasion;
    }

    public Person(AgeRange ageRange, String occasion, Gender gender) {
        this.ageRange = ageRange;
        this.occasion = occasion;
        this.gender = gender;
    }

    public AgeRange getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(AgeRange ageRange) {
        this.ageRange = ageRange;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    
}
