package com.example.pactprovider;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ZooServiceTest {
    @Test
    public void listAnimals_2animals_returnsAnimals() {
        List<Animal> expectedAnimals = Arrays.asList(
                new Animal("tiger"),
                new Animal("shark")
        );

        ZooService zooService = new ZooService();
        zooService.setAnimalNames("tiger", "shark");

        assertThat(zooService.listAnimals()).isEqualTo(expectedAnimals);
    }

    @Test
    public void listAnimals_noAnimals_returnsEmptyList() {
        ZooService zooService = new ZooService();
        assertThat(zooService.listAnimals()).isEmpty();
    }
}