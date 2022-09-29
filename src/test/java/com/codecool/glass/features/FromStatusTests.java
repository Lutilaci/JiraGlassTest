package com.codecool.glass.features;

import com.codecool.glass.pages.GlassPageMatrix;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static com.codecool.glass.utils.DriverSingleton.quitDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FromStatusTests {
    private static GlassPageMatrix glassPage;

    @BeforeAll
    public void setUp() {
        glassPage = new GlassPageMatrix();
        glassPage.logIn();
        glassPage.openUrl(glassPage.glassUrl);
        glassPage.skipTutorial();
    }
    @AfterAll
    public void tearDown(){
        quitDriver();
    }

    @Test
    public void IsFromStatusColumn(){
        assertTrue(glassPage.IsColumn("From status"));
    }

    @Test
    public void DisplayRightFromStatus(){
        assertTrue(glassPage.HasNameInTheTable("BLUE PILL", "Change My Mind", "From status"));
    }
}
