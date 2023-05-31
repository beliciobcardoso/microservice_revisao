package com.exemplo.specieservice.controller;

import com.exemplo.specieservice.model.Specie;
import com.exemplo.specieservice.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/species")
@CrossOrigin(origins = "*")
public class SpecieController {
    private static Logger log = Logger.getLogger(SpecieController.class.getName());

    @Autowired
    private AnimalService animalService;


    @RequestMapping(method = RequestMethod.GET, path = "/specie")
    public ResponseEntity<List<Specie>> getSpecies(){
        log.info("getSpecies");
        return ResponseEntity.ok(animalService.getAnimals());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/specie/{specie}")
    public ResponseEntity<List<Specie>> getSpecie(@PathVariable String specie){
        log.info("getSpecie: " + specie);
        return ResponseEntity.ok(animalService.getSpecies(specie));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/specie/id/", params = {"id"})
    public ResponseEntity<Specie> getSpecie(Long id){
        log.info("getSpecie: " + id);
        return ResponseEntity.ok(animalService.getSpecie(id));
    }

}
