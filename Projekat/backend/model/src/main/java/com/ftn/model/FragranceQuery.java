package com.ftn.model;

import com.ftn.model.enums.Family;
import com.ftn.model.enums.Season;

public class FragranceQuery {
    private String brand;
    private Family family;
    private Season season;
    private Integer previousCost;

    public FragranceQuery() {
    }

    public FragranceQuery(String brand) {
        this.brand = brand;
    }

    public FragranceQuery(Season season) {
        this.season = season;
    }

    public FragranceQuery(Integer previousCost) {
        this.previousCost = previousCost;
    }

    public FragranceQuery(String brand, Family family) {
        this.brand = brand;
        this.family = family;
    }

    public FragranceQuery(Season season, Integer previousCost) {
        this.season = season;
        this.previousCost = previousCost;
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

    public Integer getPreviousCost() {
        return previousCost;
    }

    public void setPreviousCost(Integer previousCost) {
        this.previousCost = previousCost;
    }

}
