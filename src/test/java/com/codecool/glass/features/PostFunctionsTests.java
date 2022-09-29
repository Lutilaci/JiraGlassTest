package com.codecool.glass.features;

import com.codecool.glass.pages.GlassPageMatrix;
import org.junit.jupiter.api.*;

import static com.codecool.glass.utils.DriverSingleton.quitDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PostFunctionsTests {
    private static GlassPageMatrix glassPage;
    int defaultCounter = 5;
    int customCounter = 2;

    @BeforeAll
    public void setUp() {
        glassPage = new GlassPageMatrix();
        glassPage.logIn();
        glassPage.openUrl(glassPage.glassUrl);
        glassPage.skipTutorial();
    }
    @AfterEach
    public void GoToStart() {
        glassPage.openUrl(glassPage.glassUrl);
    }
    @AfterAll
    public void tearDown(){
        quitDriver();
    }

    @Test
    public void IsOkMainPostCounter(){

        assertTrue(glassPage.IsMainPostCounter(defaultCounter, customCounter));
    }

    @Test
    public void IsOkDetailsPostCounter(){

        assertTrue(glassPage.IsDetailsPostCounter(customCounter + defaultCounter));
    }

    @Test
    public void IsDisplayThirdPartyPost(){
        glassPage.GoToPostDetails();

        assertTrue(glassPage.HasPostFunction("The current issue will be cloned to the project Same as original with the issue type Same as original."));
    }

    @Test
    public void IsDisplayAllPosts(){
        glassPage.GoToPostDetails();

        assertTrue(glassPage.HasAllPostFunctions(customCounter + defaultCounter));
    }

    //have all links admin...2...3
}
