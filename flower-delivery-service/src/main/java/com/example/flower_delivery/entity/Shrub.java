package com.example.flower_delivery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.Nationalized;

@Entity
public class Shrub extends Plant{

    private int heightCm;
    private int widthCm;

    //Getter
    public int getHeightCm() {
        return heightCm;
    }
    public void setHeightCm(int heightCm){
        this.heightCm = heightCm;
    }

    public int getWidthCm() {
        return widthCm;
    }

    public void setWidthCm(int widthCm){
        this.widthCm = widthCm;
    }
}
