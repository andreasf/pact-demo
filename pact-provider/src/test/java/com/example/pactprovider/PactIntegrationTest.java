package com.example.pactprovider;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

@RunWith(PactRunner.class)
@Provider("zoo")
@PactFolder("../pact-consumer/pacts")
public class PactIntegrationTest {
    private static final int PORT = 8123;

    private static ConfigurableApplicationContext context;

    @TestTarget
    public final Target target = new HttpTarget(PORT);

    @BeforeClass
    public static void beforeAll() {
        SpringApplication springApplication = new SpringApplication(PactproviderApplication.class);

        springApplication.setAdditionalProfiles("pact");
        context = springApplication.run("--server.port=" + PORT);
    }

    @AfterClass
    public static void afterAll() {
        context.stop();
    }

    @State("3 animals")
    public void to3AnimalsState() { }
}
