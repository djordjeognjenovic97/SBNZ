package com.ftn.model;

import com.ftn.model.enums.Family;
import com.ftn.model.enums.Season;

public class FragranceQuery {
    private String brand;
    private Family family;
    private Season season;

    public FragranceQuery() {
    }

    public FragranceQuery(String brand) {
        this.brand = brand;
    }

    public FragranceQuery(Season season) {
        this.season = season;
    }

    public FragranceQuery(String brand, Family family) {
        this.brand = brand;
        this.family = family;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

}
