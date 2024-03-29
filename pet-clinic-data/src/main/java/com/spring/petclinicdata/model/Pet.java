package com.spring.petclinicdata.model;

import java.time.LocalDate;

public class Pet extends BaseEntity {

    private String name;
    private PetType petType;
    private Owner owner;
    private LocalDate bDay;

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getbDay() {
        return bDay;
    }

    public void setbDay(LocalDate bDay) {
        this.bDay = bDay;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
