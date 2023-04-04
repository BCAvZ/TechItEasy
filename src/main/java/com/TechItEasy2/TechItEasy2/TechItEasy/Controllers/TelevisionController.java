package com.TechItEasy2.TechItEasy2.TechItEasy.Controllers;


import com.TechItEasy2.TechItEasy2.Dtos.IdInputDto;
import com.TechItEasy2.TechItEasy2.Dtos.TelevisionDto;
import com.TechItEasy2.TechItEasy2.Dtos.TelevisionInputDto;
import com.TechItEasy2.TechItEasy2.Repositories.TelevisionRepository;
import com.TechItEasy2.TechItEasy2.Service.TelevisionService;
import com.TechItEasy2.TechItEasy2.TechItEasy.Exceptions.RecordNotFoundException;
import com.TechItEasy2.TechItEasy2.Models.Television;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("tvs")
public class TelevisionController {

//    TelevisionRepository repos;

    private final TelevisionService service;

//    private List<Television> televisions = new ArrayList<>();
//    private List<String> televisionDataBase = new ArrayList<>();

    public TelevisionController(TelevisionService service) {
        this.service = service;
    }

    // This gets the TVS from the ArrayList NOT the database
//    @GetMapping("")
//    public List getTvs(){
//        return televisions;
//    }

    @GetMapping("")
    public ResponseEntity<List<TelevisionDto>> getTvs(){
        return ResponseEntity.ok().body(service.getTvs());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Television> getTv(@PathVariable int id){
//
//        if (id >= 0 && id < televisionDataBase.size()){
//            return new ResponseEntity<>(televisions.get(id), HttpStatus.OK);
//
//        } else {
//            throw new IndexOutOfBoundsException("Not found too big or small");
//        }
//    }

//    @GetMapping("name/{id}")
//    public ResponseEntity<String> tvNames(@PathVariable int id){
//        if (id == 5){
//            throw new RecordNotFoundException("Not found");
//        }
//        return new ResponseEntity<>(televisionDataBase.get(id), HttpStatus.OK);
//    }
//
    @PutMapping("{id}")
    public ResponseEntity<TelevisionDto> editTvNames(@PathVariable Long id, @RequestBody TelevisionInputDto t){
        return ResponseEntity.ok(service.editTv(id, t));

    }

    @PutMapping("{id}/remotecontroller")
    public ResponseEntity<TelevisionDto> linkTvAndRemote(@PathVariable("id") Long id, @RequestBody IdInputDto remoteControllerId){
        service.assignRemoteControllerToTelevision(id, remoteControllerId.id);
        return ResponseEntity.noContent().build();
    }

    // Deze postmap slaat het opgegeven model op in een arraylist NIET in de database
//    @PostMapping("")
//    public ResponseEntity<Television> postTv(@RequestBody Television t){
//        televisions.add(t);
//        return new ResponseEntity<>(t, HttpStatus.CREATED);
//    }

    @PostMapping("")
    public ResponseEntity<TelevisionInputDto> postTv(@RequestBody TelevisionInputDto t){

        service.postTv(t);
        return ResponseEntity.ok(t);
    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Television> editTv(@PathVariable int id, @RequestBody Television t){
//        if (id >= 0 && id < televisions.size()) {
//            televisions.set(id, t);
//            return new ResponseEntity<>(t, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//    }
//
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeTv(@PathVariable Long id){

        service.removeTv(id);
        return ResponseEntity.noContent().build();
    }

}
