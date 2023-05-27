package com.ftn.model;

import java.util.List;

public class AccumulateFragrance {
    private String brandName;
    private Integer minPrice;
    private Integer maxPrice;
    private Double avgPrice;
    private List<Fragrance> fragrances;

    public AccumulateFragrance() {
    }

    public AccumulateFragrance(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public List<Fragrance> getFragrances() {
        return fragrances;
    }

    public void setFragrances(List<Fragrance> fragrances) {
        this.fragrances = fragrances;
    }

    
}
