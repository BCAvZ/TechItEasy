package com.TechItEasy2.TechItEasy2.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "wallbrackets")
public class WallBracket {

    @Id
    @GeneratedValue
    private Long id;

    private String size;
    private boolean adjustable;
    private String name;
    private Double price;

    public WallBracket(){}

    public WallBracket(Long id, String size, boolean adjustable, String name, Double price) {
        this.id = id;
        this.size = size;
        this.adjustable = adjustable;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isAdjustable() {
        return adjustable;
    }

    public void setAdjustable(boolean adjustable) {
        this.adjustable = adjustable;
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
