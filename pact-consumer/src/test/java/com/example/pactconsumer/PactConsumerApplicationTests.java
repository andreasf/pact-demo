package com.example.pactconsumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"zoo.api.base.url=http://localhost:1234/zoo"})
public class PactConsumerApplicationTests {

    @Test
    public void contextLoads() {
    }

}
