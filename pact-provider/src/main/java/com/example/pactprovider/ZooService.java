package com.example.pactprovider;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ZooService {
    private List<Animal> animals = Collections.emptyList();

    public List<Animal> listAnimals() {
        return animals;
    }

    public void setAnimalNames(String... animalNames) {
        List<Animal> newAnimals = new ArrayList<>();

        for (String name : animalNames) {
            newAnimals.add(new Animal(name));
        }

        this.animals = newAnimals;
    }
}
