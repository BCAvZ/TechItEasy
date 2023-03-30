package com.TechItEasy2.TechItEasy2.Dtos;

public class CIModuleDto {

    public Long id;

    public String type;
    public String name;
    public Double price;

    public CIModuleDto(){

    }

    public CIModuleDto(Long id, String type, String name, Double price) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.price = price;
    }
}
