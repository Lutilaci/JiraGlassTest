package com.codecool.glass.features;

import com.codecool.glass.pages.GlassPageMatrix;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static com.codecool.glass.utils.DriverSingleton.quitDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TransitionScreenTests {
    private static GlassPageMatrix glassPage;

    @BeforeAll
    public void setUp() {
        glassPage = new GlassPageMatrix();
        glassPage.logIn();
        glassPage.openUrl(glassPage.glassEpicUrl);
        glassPage.skipTutorial();
    }
    @AfterAll
    public void tearDown(){
        quitDriver();
    }

    @Test
    public void IsTransitionScreenColumn(){
        assertTrue(glassPage.IsColumn("Transition Screen"));
    }

    @Test
    public void DisplayRightScreen(){
        assertTrue(glassPage.HasNameInTheTable("Default Screen", "Change My Mind", "Transition Screen"));
    }

}
