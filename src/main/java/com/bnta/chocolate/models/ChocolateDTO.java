package com.bnta.chocolate.models;

public class ChocolateDTO {

    private String name;
    private int cocoaPercentage;
    private int estateId;

    public ChocolateDTO() {
    }

    public ChocolateDTO(String name, int cocoaPercentage, int estateId) {
        this.name = name;
        this.cocoaPercentage = cocoaPercentage;
        this.estateId = estateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCocoaPercentage() {
        return cocoaPercentage;
    }

    public void setCocoaPercentage(int cocoaPercentage) {
        this.cocoaPercentage = cocoaPercentage;
    }

    public int getEstateId() {
        return estateId;
    }

    public void setEstateId(int estateId) {
        this.estateId = estateId;
    }
}

// chocolate DTO used to handle estate_id because chocolate has an estate as a property
// we don't want all the info about the estate to be printed out (see screenshots)
// need to think about what the front end wants us to show
// created chocolate DTO so that result shown at front end is neater than what is printed out with chocolate
