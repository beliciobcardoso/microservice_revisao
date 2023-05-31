package com.exemplo.animalservice.repository;

import com.exemplo.animalservice.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findBySpecie(String specie);
}
