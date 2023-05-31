package com.exemplo.animalservice.controller;

import com.exemplo.animalservice.model.Animal;
import com.exemplo.animalservice.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
@RequestMapping("/animals")
@CrossOrigin(origins = "*")
public class AnimalController {
    private static Logger log = Logger.getLogger(AnimalController.class.getName());

    @Autowired
    private AnimalService animalService;

    @RequestMapping(method = RequestMethod.GET, path = "/animal")
    public ResponseEntity<List<Animal>> findAll() {
        return ResponseEntity.ok(animalService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/animal/{specie}")
    public ResponseEntity<List<Animal>> findBySpecie(@PathVariable String specie) {

        List<Animal> specieList = animalService.findBySpecie(specie);

        if (specieList.isEmpty()) {
            log.info("A espécie " + specie + " não foi encontrada.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.info("findBySpecie: " + specie);
        return new ResponseEntity<>(specieList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/animal/id/", params = {"id"})
    public ResponseEntity<Animal> findById(Long id) {

        log.info("findById: " + id);

        Animal animal = animalService.findById(id);

        return new ResponseEntity<>(animal, HttpStatus.OK);
    }
}
