package com.ftn.model;

import com.ftn.model.enums.Concentration;
import com.ftn.model.enums.Family;
import com.ftn.model.enums.Gender;
import com.ftn.model.enums.Longevity;
import com.ftn.model.enums.Projection;

public class Fragrance {
    private String name;
    private Gender gender;  
    private Longevity longevity;
    private Projection projection;
    private Concentration concentration;
    private String designer;
    private Family family;
    private Integer score;

    public Fragrance() {
    }

    public Fragrance(String designer, Integer score) {
        this.designer = designer;
        this.score = score;
    }

    public Fragrance(String designer, Family family, Integer score) {
        this.designer = designer;
        this.family = family;
        this.score = score;
    }

    public Fragrance(Gender gender, Integer score) {
        this.gender = gender;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Longevity getLongevity() {
        return longevity;
    }

    public void setLongevity(Longevity longevity) {
        this.longevity = longevity;
    }

    public Projection getProjection() {
        return projection;
    }

    public void setProjection(Projection projection) {
        this.projection = projection;
    }

    public Concentration getConcentration() {
        return concentration;
    }

    public void setConcentration(Concentration concentration) {
        this.concentration = concentration;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void addScore(Integer score) {
        this.score += score;
    }
}
