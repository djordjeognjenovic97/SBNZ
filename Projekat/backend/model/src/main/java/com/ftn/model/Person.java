package com.ftn.model;

import com.ftn.model.enums.AgeRange;

public class Person {
    private AgeRange ageRange;
    private String occasion;

    public Person() {
    }

    public Person(AgeRange ageRange, String occasion) {
        this.ageRange = ageRange;
        this.occasion = occasion;
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
}
