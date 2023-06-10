package com.ftn.service.dto;

public class AccumulateFragranceDTO {
    private String brandName;
    private Integer minPrice;
    private Integer maxPrice;
    private Double avgPrice;
    
    public AccumulateFragranceDTO() {
    }

    public AccumulateFragranceDTO(String brandName, Integer minPrice, Integer maxPrice, Double avgPrice) {
        this.brandName = brandName;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.avgPrice = avgPrice;
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

    
}
