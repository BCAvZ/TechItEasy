package com.TechItEasy2.TechItEasy2.Dtos;

public class CIModuleInputDto {

    public String type;
    public String name;
    public Double price;

    public CIModuleInputDto(){

    }

    public CIModuleInputDto(String type, String name, Double price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

}
