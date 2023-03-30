package com.TechItEasy2.TechItEasy2.Dtos;

public class WallBracketDto {

    public Long id;

    public String size;
    public boolean adjustable;
    public String name;
    public Double price;

    public WallBracketDto(){}

    public WallBracketDto(Long id, String size, boolean adjustable, String name, Double price) {
        this.id = id;
        this.size = size;
        this.adjustable = adjustable;
        this.name = name;
        this.price = price;
    }

}
