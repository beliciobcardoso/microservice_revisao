package com.exemplo.specieservice.service;

import com.exemplo.specieservice.model.Specie;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ANIMAL-SERVICE")
@LoadBalancerClient(name = "ANIMAL-SERVICE")
public interface AnimalService {

    @RequestMapping(method = RequestMethod.GET, value = "/animals/animal")
    List<Specie> getAnimals();

    @RequestMapping(method = RequestMethod.GET, value = "/animals/animal/{specie}")
    List<Specie> getSpecies(@PathVariable String specie);

    @RequestMapping(method = RequestMethod.GET, value = "/animals/animal/id/")
    Specie getSpecie(@RequestParam Long id);



}
