package com.ftn.model;

import com.ftn.model.enums.Cost;
import com.ftn.model.enums.Longevity;

public class MidClss {
    private Cost costTier;
    private Longevity longevity;
    
    public MidClss() {
    }

    public MidClss(Longevity longevity) {
        this.longevity = longevity;
    }

    public MidClss(Cost costTier) {
        this.costTier = costTier;
    }

    public MidClss(Cost costTier, Longevity longevity) {
        this.costTier = costTier;
        this.longevity = longevity;
    }

    public Cost getCostTier() {
        return costTier;
    }

    public void setCostTier(Cost costTier) {
        this.costTier = costTier;
    }

    public Longevity getLongevity() {
        return longevity;
    }

    public void setLongevity(Longevity longevity) {
        this.longevity = longevity;
    }
    
}
