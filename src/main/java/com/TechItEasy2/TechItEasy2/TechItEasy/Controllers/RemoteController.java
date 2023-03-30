package com.TechItEasy2.TechItEasy2.TechItEasy.Controllers;

import com.TechItEasy2.TechItEasy2.Dtos.RemoteControllerDto;
import com.TechItEasy2.TechItEasy2.Dtos.RemoteControllerInputDto;
import com.TechItEasy2.TechItEasy2.Dtos.TelevisionDto;
import com.TechItEasy2.TechItEasy2.Dtos.TelevisionInputDto;
import com.TechItEasy2.TechItEasy2.Service.RemoteControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("remotecontrollers")
public class RemoteController {

    private final RemoteControllerService service;


    public RemoteController(RemoteControllerService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<RemoteControllerDto>> getTvs(){
        return ResponseEntity.ok().body(service.getRemoteControllers());
    }

    @PutMapping("{id}")
    public ResponseEntity<RemoteControllerDto> editTvNames(@PathVariable Long id, @RequestBody RemoteControllerInputDto rm){
        return ResponseEntity.ok(service.editRemoteController(id, rm));
    }

    @PostMapping("")
    public ResponseEntity<RemoteControllerInputDto> postTv(@RequestBody RemoteControllerInputDto rm){

        service.postRemoteController(rm);
        return ResponseEntity.ok(rm);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeTv(@PathVariable Long id){

        service.removeRemoteController(id);
        return ResponseEntity.noContent().build();
    }

}
