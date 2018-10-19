package com.example.pactprovider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ZooController {
    private ZooService zooService;

    public ZooController(ZooService zooService) {
        this.zooService = zooService;
    }

    @GetMapping("/animals")
    public AnimalListResponse listAnimals() {
        List<AnimalResponse> animalResponses = toAnimalResponses(zooService.listAnimals());

        return new AnimalListResponse(animalResponses);
    }

    private List<AnimalResponse> toAnimalResponses(List<Animal> animals) {
        return animals.stream()
                .map(animal -> new AnimalResponse(animal.getName()))
                .collect(Collectors.toList());
    }
}
