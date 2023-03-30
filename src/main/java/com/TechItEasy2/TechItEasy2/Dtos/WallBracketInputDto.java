package com.TechItEasy2.TechItEasy2.Dtos;

public class WallBracketInputDto {

    public String size;
    public boolean adjustable;
    public String name;
    public Double price;

    public WallBracketInputDto(){}

    public WallBracketInputDto(String size, boolean adjustable, String name, Double price) {
        this.size = size;
        this.adjustable = adjustable;
        this.name = name;
        this.price = price;
    }

}
