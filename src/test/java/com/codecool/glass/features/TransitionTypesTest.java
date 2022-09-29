package com.codecool.glass.features;

import com.codecool.glass.pages.GlassPageMatrix;
import org.junit.jupiter.api.*;

import static com.codecool.glass.utils.DriverSingleton.quitDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TransitionTypesTest {
    private static GlassPageMatrix glassPage;

    @BeforeAll
    public void setUp() {
        glassPage = new GlassPageMatrix();
        glassPage.logIn();
        glassPage.openUrl("/projects/NC?selectedItem=com.metainf.jira.plugin:glass-project-documentation#/home/issueTypes/10000/transitions");
        glassPage.skipTutorial();
    }

    @AfterAll
    public void tearDown(){
        quitDriver();
    }

    @Test
    public void HaveGlobalTransition(){
        assertTrue(glassPage.HaveElement(glassPage.globalRow, "Global"));
    }
    @Test
    public void HaveInitialTransition(){
        assertTrue(glassPage.HaveElement(glassPage.initialRow, "Initial"));
    }
    @Test
    public void HaveReusedTransition(){
        assertTrue(glassPage.HaveElement(glassPage.reusedRow, "Reused"));
    }
    @Test
    public void HaveUniqueTransition(){
        assertTrue(glassPage.HaveElement(glassPage.uniqueRow, "Unique"));
    }
    }


