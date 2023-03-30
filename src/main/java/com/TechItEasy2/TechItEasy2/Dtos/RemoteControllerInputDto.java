package com.TechItEasy2.TechItEasy2.Dtos;

public class RemoteControllerInputDto {

    public String compatibleWith;
    public String batteryType;
    public String name;
    public String brand;
    public Double price;
    public Integer originalStock;

    public RemoteControllerInputDto() {
    }

    public RemoteControllerInputDto(String compatibleWith, String batteryType, String name, String brand, Double price, Integer originalStock) {
        this.compatibleWith = compatibleWith;
        this.batteryType = batteryType;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.originalStock = originalStock;
    }
}
