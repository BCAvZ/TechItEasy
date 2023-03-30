package com.TechItEasy2.TechItEasy2.Dtos;

import com.TechItEasy2.TechItEasy2.Models.Television;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

public class TelevisionDto {

    public Long tvId;
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

    public static TelevisionDto fromTelevision(Television t){
        var dto = new TelevisionDto();


        dto.tvId = t.getTvId();
        dto.type = t.getType();
        dto.brand = t.getBrand();
        dto.name = t.getName();
        dto.price = t.getPrice();
        dto.availableSize = t.getAvailableSize();
        dto.refreshRate = t.getRefreshRate();
        dto.screenType = t.getScreenType();
        dto.screenQuality = t.getScreenQuality();
        dto.smartTv = t.getSmartTv();
        dto.wifi = t.getWifi();
        dto.voiceControl = t.getVoiceControl();
        dto.hdr = t.getHdr();
        dto.bluetooth = t.getBluetooth();
        dto.ambiLight = t.getAmbiLight();
        dto.originalStock = t.getOriginalStock();
        dto.sold =t.getSold();

        return dto;
    }


}
