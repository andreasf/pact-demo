package com.example.pactconsumer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ZooApiClient {
    private String baseUrl;
    private RestTemplate restTemplate;

    public ZooApiClient(String baseUrl, RestTemplate restTemplate) {
        this.baseUrl = baseUrl;
        this.restTemplate = restTemplate;
    }

    public List<Animal> listAnimals() {
        String url = baseUrl + "/animals";
        AnimalList animalList = restTemplate.getForObject(url, AnimalList.class);
        return animalList.getAnimals();
    }
}
