package com.TechItEasy2.TechItEasy2.Service;

import com.TechItEasy2.TechItEasy2.Dtos.CIModuleDto;
import com.TechItEasy2.TechItEasy2.Dtos.CIModuleInputDto;
import com.TechItEasy2.TechItEasy2.Models.CIModule;
import com.TechItEasy2.TechItEasy2.Repositories.CIModuleRepository;
import com.TechItEasy2.TechItEasy2.TechItEasy.Exceptions.RecordNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CIModuleService {

    private CIModuleRepository repos;

    public CIModuleService(CIModuleRepository CIModuleRepository) {
        this.repos = CIModuleRepository;
    }

    public List<CIModuleDto> getCIModules(){

        Iterable<CIModule> CIModulesToReturn = repos.findAll();
        List<CIModuleDto> CIModuleDtos = new ArrayList<>();

        for (CIModule rm : CIModulesToReturn ) {
            CIModuleDto dto = changeToCIModuleDto(rm);
            CIModuleDtos.add(dto);
        }
        return CIModuleDtos;
    }

    public CIModuleDto postCIModule(CIModuleInputDto dto){

        CIModule rm = changeToCIModule(dto);
        repos.save(rm);

        return changeToCIModuleDto(rm);
    }

    public CIModuleDto editCIModule(Long id, CIModuleInputDto newRM){

        Optional<CIModule> CIModuleOptional = repos.findById(id);
        if(CIModuleOptional.isPresent()){
            CIModule CIModule1 = CIModuleOptional.get();

            CIModule1.setType(newRM.type);
            CIModule1.setName(newRM.name);
            CIModule1.setPrice(newRM.price);

            repos.save(CIModule1);
            return changeToCIModuleDto(CIModule1);
        }

        else {
            throw new RecordNotFoundException("geen CIModule gevonden");
        }
    }

    public void removeCIModule(Long id) {

        Optional<CIModule> CIModuleOptional = repos.findById(id);
        if (CIModuleOptional.isPresent()) {
            repos.deleteById(id);
        } else {
            throw new RecordNotFoundException("geen CIModule gevonden");
        }
    }


    public CIModule changeToCIModule(CIModuleInputDto Dto){
        var rm = new CIModule();

        rm.setType(Dto.type);
        rm.setName(Dto.name);
        rm.setPrice(Dto.price);

        return rm;
    }

    public static CIModuleDto changeToCIModuleDto(CIModule rm){
        var dto = new CIModuleDto();

        dto.type = rm.getType();
        dto.name = rm.getName();
        dto.price = rm.getPrice();

        return dto;
    }

}
