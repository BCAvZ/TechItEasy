package com.TechItEasy2.TechItEasy2.Dtos;

public class RemoteControllerDto {

     public Long id;
     public String compatibleWith;
    public String batteryType;
    public String name;
    public String brand;
    public Double price;
    public Integer originalStock;

    public RemoteControllerDto() {
    }

    public RemoteControllerDto(Long id, String compatibleWith, String batteryType, String name, String brand, Double price, Integer originalStock) {
        this.id = id;
        this.compatibleWith = compatibleWith;
        this.batteryType = batteryType;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.originalStock = originalStock;
    }
}
