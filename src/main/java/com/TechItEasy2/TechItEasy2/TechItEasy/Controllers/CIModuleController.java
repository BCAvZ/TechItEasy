package com.TechItEasy2.TechItEasy2.TechItEasy.Controllers;

import com.TechItEasy2.TechItEasy2.Dtos.CIModuleDto;
import com.TechItEasy2.TechItEasy2.Dtos.CIModuleInputDto;
import com.TechItEasy2.TechItEasy2.Dtos.RemoteControllerDto;
import com.TechItEasy2.TechItEasy2.Dtos.RemoteControllerInputDto;
import com.TechItEasy2.TechItEasy2.Service.CIModuleService;
import com.TechItEasy2.TechItEasy2.Service.RemoteControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cimodules")
public class CIModuleController {

    private final CIModuleService service;


    public CIModuleController(CIModuleService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<CIModuleDto>> getCIModules(){
        return ResponseEntity.ok().body(service.getCIModules());
    }

    @PutMapping("{id}")
    public ResponseEntity<CIModuleDto> editCIModuleNames(@PathVariable Long id, @RequestBody CIModuleInputDto rm){
        return ResponseEntity.ok(service.editCIModule(id, rm));
    }

    @PostMapping("")
    public ResponseEntity<CIModuleInputDto> postCIModule(@RequestBody CIModuleInputDto rm){

        service.postCIModule(rm);
        return ResponseEntity.ok(rm);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeCIModule(@PathVariable Long id){

        service.removeCIModule(id);
        return ResponseEntity.noContent().build();
    }
}
