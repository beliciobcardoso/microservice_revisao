package com.exemplo.animalservice.service;

import com.exemplo.animalservice.model.Animal;
import com.exemplo.animalservice.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

   public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    public Animal findById(Long id) {
        return animalRepository.findById(id).get();
    }

    public Animal save(Animal animal) {
        return animalRepository.save(animal);
    }

    public List<Animal> findBySpecie(String specie) {
        return animalRepository.findBySpecie(specie);
    }
}
