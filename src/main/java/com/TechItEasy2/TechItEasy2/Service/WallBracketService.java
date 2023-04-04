package com.TechItEasy2.TechItEasy2.Service;

import com.TechItEasy2.TechItEasy2.Dtos.WallBracketDto;
import com.TechItEasy2.TechItEasy2.Dtos.WallBracketInputDto;
import com.TechItEasy2.TechItEasy2.Models.WallBracket;
import com.TechItEasy2.TechItEasy2.Repositories.WallBracketRepository;
import com.TechItEasy2.TechItEasy2.TechItEasy.Exceptions.RecordNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WallBracketService {

    private WallBracketRepository repos;

    public WallBracketService(WallBracketRepository repos) {
        this.repos = repos;
    }

    public List<WallBracketDto> getWallBrackets(){
        Iterable<WallBracket> WallBracketToReturn = repos.findAll();
        List<WallBracketDto> WallBracketDtos = new ArrayList<>();

        for (WallBracket rm : WallBracketToReturn ) {
            WallBracketDto dto = changeToWallBracketDto(rm);
            WallBracketDtos.add(dto);
        }
        return WallBracketDtos;
    }


    public WallBracketDto postWallBracket(WallBracketInputDto dto){

        WallBracket rm = changeToWallBracket(dto);
        repos.save(rm);

        return changeToWallBracketDto(rm);
    }

    public WallBracketDto editWallBracket(Long id, WallBracketInputDto newRM){

        Optional<WallBracket> WallBracketOptional = repos.findById(id);
        if(WallBracketOptional.isPresent()){
            WallBracket WallBracket1 = WallBracketOptional.get();

            WallBracket1.setSize(newRM.size);
            WallBracket1.setName(newRM.name);
            WallBracket1.setPrice(newRM.price);
            WallBracket1.setAdjustable(newRM.adjustable);

            repos.save(WallBracket1);
            return changeToWallBracketDto(WallBracket1);
        }

        else {
            throw new RecordNotFoundException("geen WallBracket gevonden");
        }
    }

    public void removeWallBracket(Long id) {

        Optional<WallBracket> WallBracketOptional = repos.findById(id);
        if (WallBracketOptional.isPresent()) {
            repos.deleteById(id);
        } else {
            throw new RecordNotFoundException("geen WallBracket gevonden");
        }
    }


    public WallBracket changeToWallBracket(WallBracketInputDto Dto){
        var rm = new WallBracket();

        rm.setSize(Dto.size);
        rm.setName(Dto.name);
        rm.setPrice(Dto.price);
        rm.setAdjustable(Dto.adjustable);

        return rm;
    }

    public static WallBracketDto changeToWallBracketDto(WallBracket rm){
        var dto = new WallBracketDto();

        dto.id = rm.getId();
        dto.adjustable = rm.isAdjustable();
        dto.size = rm.getSize();
        dto.name = rm.getName();
        dto.price = rm.getPrice();

        return dto;
    }


}
