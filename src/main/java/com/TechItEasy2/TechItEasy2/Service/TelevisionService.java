package com.TechItEasy2.TechItEasy2.Service;

import com.TechItEasy2.TechItEasy2.Dtos.TelevisionDto;
import com.TechItEasy2.TechItEasy2.Dtos.TelevisionInputDto;
import com.TechItEasy2.TechItEasy2.Models.Television;
import com.TechItEasy2.TechItEasy2.Repositories.TelevisionRepository;
import com.TechItEasy2.TechItEasy2.TechItEasy.Exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private TelevisionRepository repos;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.repos = televisionRepository;
    }

    public List<TelevisionDto> getTvs(){

        Iterable<Television> televisionsToReturn = repos.findAll();
        List<TelevisionDto> televisionDtos = new ArrayList<>();

        for (Television t : televisionsToReturn ) {
            TelevisionDto dto = TelevisionDto.fromTelevision(t);
            televisionDtos.add(dto);
        }
        return televisionDtos;
    }

    public TelevisionDto postTv(TelevisionInputDto dto){

        Television tv = toTelevision(dto);
        repos.save(tv);

        return TelevisionDto.fromTelevision(tv);
    }


    public TelevisionDto editTv(Long id, TelevisionInputDto newT){

        Optional<Television> televisionOptional = repos.findById(id);
        if(televisionOptional.isPresent()){
            Television television1 = televisionOptional.get();

            television1.setAmbiLight(newT.ambiLight);
            television1.setAvailableSize(newT.availableSize);
            television1.setBluetooth(newT.bluetooth);
            television1.setBrand(newT.brand);
            television1.setHdr(newT.hdr);
            television1.setName(newT.name);
            television1.setOriginalStock(newT.originalStock);
            television1.setPrice(newT.price);
            television1.setRefreshRate(newT.refreshRate);
            television1.setScreenQuality(newT.screenQuality);
            television1.setScreenType(newT.screenType);
            television1.setSmartTv(newT.smartTv);
            television1.setSold(newT.sold);
            television1.setType(newT.type);
            television1.setVoiceControl(newT.voiceControl);
            television1.setWifi(newT.wifi);

            repos.save(television1);
            return TelevisionDto.fromTelevision(television1);
        }

        else {
            throw new RecordNotFoundException("geen televisie gevonden");
        }
    }

    public Television toTelevision(TelevisionInputDto Dto){
        var t = new Television();

        t.setType(Dto.type);
        t.setBrand(Dto.brand);
        t.setName(Dto.name);
        t.setPrice(Dto.price);
        t.setAvailableSize(Dto.availableSize);
        t.setRefreshRate(Dto.refreshRate);
        t.setScreenType(Dto.screenType);
        t.setScreenQuality(Dto.screenQuality);
        t.setSmartTv(Dto.smartTv);
        t.setWifi(Dto.wifi);
        t.setVoiceControl(Dto.voiceControl);
        t.setHdr(Dto.hdr);
        t.setBluetooth(Dto.bluetooth);
        t.setAmbiLight(Dto.ambiLight);
        t.setOriginalStock(Dto.originalStock);
        t.setSold(Dto.sold);

        return t;
    }

    public void removeTv(Long id){

        Optional<Television> televisionOptional = repos.findById(id);
        if (televisionOptional.isPresent()) {
            repos.deleteById(id);
        } else {
            throw new RecordNotFoundException("geen televisie gevonden");
        }

    }




}
