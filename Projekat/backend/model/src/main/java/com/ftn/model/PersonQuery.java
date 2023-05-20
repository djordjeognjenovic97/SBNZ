package com.ftn.model;

import com.ftn.model.enums.Gender;
import com.ftn.model.enums.Occasion;

public class PersonQuery {
    private Integer age;
    private Occasion occasion;
    private Gender gender;

    public PersonQuery() {
    }
    
    public PersonQuery(Integer age) {
        this.age = age;
    }

    public PersonQuery(Gender gender) {
        this.gender = gender;
    }

    public PersonQuery(Occasion occasion) {
        this.occasion = occasion;
    }

    public PersonQuery(Integer age, Gender gender) {
        this.age = age;
        this.gender = gender;
    }

    public PersonQuery(Integer age, Occasion occasion) {
        this.age = age;
        this.occasion = occasion;
    }

    public PersonQuery(Integer age, Occasion occasion, Gender gender) {
        this.age = age;
        this.occasion = occasion;
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Occasion getOccasion() {
        return occasion;
    }

    public void setOccasion(Occasion occasion) {
        this.occasion = occasion;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}
