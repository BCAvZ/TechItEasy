package com.TechItEasy2.TechItEasy2.TechItEasy.Controllers;

import com.TechItEasy2.TechItEasy2.Dtos.CIModuleDto;
import com.TechItEasy2.TechItEasy2.Dtos.CIModuleInputDto;
import com.TechItEasy2.TechItEasy2.Dtos.WallBracketDto;
import com.TechItEasy2.TechItEasy2.Dtos.WallBracketInputDto;
import com.TechItEasy2.TechItEasy2.Service.CIModuleService;
import com.TechItEasy2.TechItEasy2.Service.WallBracketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("wallbrackets")
public class WallBracketController {

    private final WallBracketService service;


    public WallBracketController(WallBracketService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<WallBracketDto>> getWallBrackets(){
        return ResponseEntity.ok().body(service.getWallBrackets());
    }

    @PutMapping("{id}")
    public ResponseEntity<WallBracketDto> editWallBracketNames(@PathVariable Long id, @RequestBody WallBracketInputDto rm){
        return ResponseEntity.ok(service.editWallBracket(id, rm));
    }

    @PostMapping("")
    public ResponseEntity<WallBracketInputDto> postWallBracket(@RequestBody WallBracketInputDto rm){

        service.postWallBracket(rm);
        return ResponseEntity.ok(rm);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeWallBracket(@PathVariable Long id){

        service.removeWallBracket(id);
        return ResponseEntity.noContent().build();
    }


}
