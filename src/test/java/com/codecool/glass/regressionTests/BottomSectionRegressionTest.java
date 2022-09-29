package com.codecool.glass.regressionTests;

import com.codecool.glass.pages.ProjectGlassPage;
import com.codecool.glass.pages.TestFestBugPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codecool.glass.utils.DriverSingleton.quitDriver;

public class BottomSectionRegressionTest {

    private static ProjectGlassPage projectGlassPage;
    private static TestFestBugPage testFestBugPage;

    @BeforeAll
    public static void setUp() {
        projectGlassPage = new ProjectGlassPage();
        testFestBugPage = new TestFestBugPage();
        projectGlassPage.logIn();
        projectGlassPage.openUrl("/projects/NC?selectedItem=com.metainf.jira.plugin:glass-project-documentation#/home/general/schemes");
        testFestBugPage.skipTutorial();
    }

    @AfterAll
    public static void tearDown(){
        quitDriver();
    }

    @Test
    public void isSchemesPresent(){
        projectGlassPage.isElementPresentAndContainWord(projectGlassPage.schemes, "Schemes");}

    @Test
    public void isSchemesButtonPresent(){
        projectGlassPage.isElementPresentAndContainWord(projectGlassPage.schemesButton, "Schemes");
    }

    @Test
    public void isComponentsButtonPresent(){
        projectGlassPage.isElementPresentAndContainWord(projectGlassPage.componentsButton, "Components");}

    @Test
    public void isVersionsButtonPResent(){
        projectGlassPage.isElementPresentAndContainWord(projectGlassPage.versionsButton, "Versions");
    }
}
