package com.example.pactprovider;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZooService {
    public List<Animal> listAnimals() {
        throw new RuntimeException("not implemented");
    }
}
