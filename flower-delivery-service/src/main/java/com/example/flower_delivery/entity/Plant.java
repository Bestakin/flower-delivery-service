package com.example.flower_delivery.entity;

import com.example.flower_delivery.controller.Views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Plant{
    @Id
    @GeneratedValue
    public Long id;

    @JsonView(Views.Public.class)
    @Nationalized
    private String name;

    @JsonView(Views.Public.class)
    @Column(precision = 12, scale = 4)
    private BigDecimal price;


     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "delivery_id")
     private Delivery delivery;

    public Plant(String name, double price){
        this.name = name;
        this.price = BigDecimal.valueOf(price);
    }

    public Plant() {}

     //Getter and Setters
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

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

    public Delivery getDelivery(){
        return delivery;
    }

    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
    }
}
