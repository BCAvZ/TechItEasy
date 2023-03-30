package com.TechItEasy2.TechItEasy2.Dtos;

import com.TechItEasy2.TechItEasy2.Models.Television;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

public class TelevisionInputDto {

    public String type;
    public String brand;

    @Size(min = 2, max = 255)
    public String name;

    @Max(8000)
    public Double price;
    public Double availableSize;
    public Double refreshRate;
    public String screenType;
    public String screenQuality;
    public Boolean smartTv;
    public Boolean wifi;
    public Boolean voiceControl;
    public Boolean hdr;
    public Boolean bluetooth;
    public Boolean ambiLight;
    public Integer originalStock;
    public Integer sold;

    public TelevisionInputDto() {
    }

    public TelevisionInputDto(String type, String brand, String name, Double price, Double availableSize, Double refreshRate, String screenType, String screenQuality, Boolean smartTv, Boolean wifi, Boolean voiceControl, Boolean hdr, Boolean bluetooth, Boolean ambiLight, Integer originalStock, Integer sold) {
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.availableSize = availableSize;
        this.refreshRate = refreshRate;
        this.screenType = screenType;
        this.screenQuality = screenQuality;
        this.smartTv = smartTv;
        this.wifi = wifi;
        this.voiceControl = voiceControl;
        this.hdr = hdr;
        this.bluetooth = bluetooth;
        this.ambiLight = ambiLight;
        this.originalStock = originalStock;
        this.sold = sold;
    }
//    public Television toTelevision(TelevisionInputDto Dto){
//        var t = new Television();
//
//
//        t.setTvId(Dto.tvId);
//        t.setType(Dto.type);
//        t.setBrand(Dto.brand);
//        t.setName(Dto.name);
//        t.setPrice(Dto.price);
//        t.setAvailableSize(Dto.availableSize);
//        t.setRefreshRate(Dto.refreshRate);
//        t.setScreenType(Dto.screenType);
//        t.setScreenQuality(Dto.screenQuality);
//        t.setSmartTv(Dto.smartTv);
//        t.setWifi(Dto.wifi);
//        t.setVoiceControl(Dto.voiceControl);
//        t.setHdr(Dto.hdr);
//        t.setBluetooth(Dto.bluetooth);
//        t.setAmbiLight(Dto.ambiLight);
//        t.setOriginalStock(Dto.originalStock);
//        t.setSold(Dto.sold);
//
//        return t;
//    }



}
