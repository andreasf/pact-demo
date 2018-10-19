package com.example.pactprovider;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ZooControllerTest {
    private MockMvc mockMvc;
    private ZooService zooService;

    @Before
    public void beforeEach() {
        zooService = mock(ZooService.class);
        ZooController zooController = new ZooController(zooService);
        mockMvc = MockMvcBuilders.standaloneSetup(zooController).build();
    }

    @Test
    public void listAnimals_returnsAnimalsFromService() throws Exception {
        when(zooService.listAnimals()).thenReturn(animals);

        mockMvc.perform(get("/animals"))
                .andExpect(status().isOk())
                .andExpect(content().json(animalsJson));

        verify(zooService).listAnimals();
    }

    private static String animalsJson = "{\n" +
            "  \"animals\": [\n" +
            "    {\n" +
            "      \"name\": \"cat\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"dolphin\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"sloth\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    List<Animal> animals = Arrays.asList(
            new Animal("cat"),
            new Animal("dolphin"),
            new Animal("sloth")
    );
}