package com.ftn.model;

public class PersonQuery {
    private Integer age;
    private String occasion;

    public PersonQuery() {
    }
    
    public PersonQuery(Integer age) {
        this.age = age;
    }

    public PersonQuery(Integer age, String occasion) {
        this.age = age;
        this.occasion = occasion;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }
}
