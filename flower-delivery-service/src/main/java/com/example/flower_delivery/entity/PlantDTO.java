package com.example.flower_delivery.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;

public class PlantDTO {
    private String name;
    private BigDecimal price;

    public PlantDTO(){}

    public PlantDTO(String name, BigDecimal price){
        this.name = name;
        this.price = price;
    }

    //Getters and Setters
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }
}
