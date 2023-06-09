package com.ftn.service.dto;

import com.ftn.model.enums.Concentration;
import com.ftn.model.enums.Family;
import com.ftn.model.enums.Gender;
import com.ftn.model.enums.Longevity;
import com.ftn.model.enums.Projection;

public class FragranceDTO {
    private Long id;
    private String fname;
    private Gender gender;  
    private Longevity longevity;
    private Projection projection;
    private Concentration concentration;
    private String designer;
    private Family family;
    private Integer price;
    private Integer score;
    
    public FragranceDTO() {
    }

    public FragranceDTO(Long id, String fname, Gender gender, Longevity longevity, Projection projection,
            Concentration concentration, String designer, Family family, Integer price, Integer score) {
        this.id = id;
        this.fname = fname;
        this.gender = gender;
        this.longevity = longevity;
        this.projection = projection;
        this.concentration = concentration;
        this.designer = designer;
        this.family = family;
        this.price = price;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return fname;
    }

    public void setName(String fname) {
        this.fname = fname;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
