package com.TechItEasy2.TechItEasy2.Service;

import com.TechItEasy2.TechItEasy2.Dtos.RemoteControllerDto;

import com.TechItEasy2.TechItEasy2.Dtos.RemoteControllerInputDto;
import com.TechItEasy2.TechItEasy2.Dtos.TelevisionDto;
import com.TechItEasy2.TechItEasy2.Dtos.TelevisionInputDto;
import com.TechItEasy2.TechItEasy2.Models.RemoteController;
import com.TechItEasy2.TechItEasy2.Models.Television;
import com.TechItEasy2.TechItEasy2.Repositories.RemoteControllerRepository;
import com.TechItEasy2.TechItEasy2.TechItEasy.Exceptions.RecordNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemoteControllerService {

    private RemoteControllerRepository repos;

    public RemoteControllerService(RemoteControllerRepository RemoteControllerRepository) {
        this.repos = RemoteControllerRepository;
    }

    public List<RemoteControllerDto> getRemoteControllers(){

        Iterable<RemoteController> remoteControllersToReturn = repos.findAll();
        List<RemoteControllerDto> RemoteControllerDtos = new ArrayList<>();

        for (RemoteController rm : remoteControllersToReturn ) {
            RemoteControllerDto dto = changeToRemoteControllerDto(rm);
            RemoteControllerDtos.add(dto);
        }
        return RemoteControllerDtos;
    }

    public RemoteControllerDto postRemoteController(RemoteControllerInputDto dto){

        RemoteController rm = changeToRemoteController(dto);
        repos.save(rm);

        return changeToRemoteControllerDto(rm);
    }

    public RemoteControllerDto editRemoteController(Long id, RemoteControllerInputDto newRM){

        Optional<RemoteController> RemoteControllerOptional = repos.findById(id);
        if(RemoteControllerOptional.isPresent()){
            RemoteController RemoteController1 = RemoteControllerOptional.get();

            RemoteController1.setBrand(newRM.brand);
            RemoteController1.setName(newRM.name);
            RemoteController1.setOriginalStock(newRM.originalStock);
            RemoteController1.setPrice(newRM.price);
            RemoteController1.setCompatibleWith(newRM.compatibleWith);
            RemoteController1.setBatteryType(newRM.batteryType);

            repos.save(RemoteController1);
            return changeToRemoteControllerDto(RemoteController1);
        }

        else {
            throw new RecordNotFoundException("geen RemoteController gevonden");
        }
    }

    public void removeRemoteController(Long id) {

        Optional<RemoteController> RemoteControllerOptional = repos.findById(id);
        if (RemoteControllerOptional.isPresent()) {
            repos.deleteById(id);
        } else {
            throw new RecordNotFoundException("geen RemoteController gevonden");
        }
    }


    public RemoteController changeToRemoteController(RemoteControllerInputDto Dto){
        var rm = new RemoteController();

        rm.setBrand(Dto.brand);
        rm.setName(Dto.name);
        rm.setPrice(Dto.price);
        rm.setOriginalStock(Dto.originalStock);
        rm.setCompatibleWith(Dto.compatibleWith);
        rm.setBatteryType(Dto.batteryType);

        return rm;
    }

    public static RemoteControllerDto changeToRemoteControllerDto(RemoteController rm){
        var dto = new RemoteControllerDto();

        dto.brand = rm.getBrand();
        dto.name = rm.getName();
        dto.price = rm.getPrice();
        dto.compatibleWith = rm.getCompatibleWith();
        dto.batteryType = rm.getBatteryType();
        dto.originalStock = rm.getOriginalStock();

        return dto;
    }



}
