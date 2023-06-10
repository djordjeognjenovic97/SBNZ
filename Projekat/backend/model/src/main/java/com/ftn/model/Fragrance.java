package com.ftn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ftn.model.enums.Concentration;
import com.ftn.model.enums.Family;
import com.ftn.model.enums.Gender;
import com.ftn.model.enums.Longevity;
import com.ftn.model.enums.Projection;

@Entity
@Table(name = "fragrance")
public class Fragrance implements Comparable { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String fname;

    @Enumerated(EnumType.STRING)
    private Gender gender;  

    @Enumerated(EnumType.STRING)
    private Longevity longevity;

    @Enumerated(EnumType.STRING)
    private Projection projection;

    @Enumerated(EnumType.STRING)
    private Concentration concentration;

    @Column
    private String designer;

    @Enumerated(EnumType.STRING)
    private Family family;

    @Column
    private Integer price;

    @Column
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

    public Fragrance(Projection projection, Integer score) {
        this.projection = projection;
        this.score = score;
    }

    public Fragrance(Concentration concentration, Integer score) {
        this.concentration = concentration;
        this.score = score;
    }

    public Fragrance(String fname, Gender gender, Projection projection, Concentration concentration, String designer, Family family, Integer score) {
        this.fname = fname;
        this.gender = gender;
        this.projection = projection;
        this.concentration = concentration;
        this.designer = designer;
        this.family = family;
        this.score = score;
    }

    public Fragrance(Long id, String fname, Gender gender, Longevity longevity, Projection projection,
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

    public void addScore(Integer score) {
        this.score += score;
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        return Integer.compare(this.getScore(),((Fragrance) o).getScore());
    }
}
