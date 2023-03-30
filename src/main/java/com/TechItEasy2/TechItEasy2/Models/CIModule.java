package com.TechItEasy2.TechItEasy2.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cimodules")
public class CIModule {

    @Id
    @GeneratedValue
    private Long id;

    private String type;
    private String name;
    private Double price;

    public CIModule(){

    }

    public CIModule(Long id, String type, String name, Double price) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
