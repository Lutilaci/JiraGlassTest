package com.codecool.glass.regressionTests;

import com.codecool.glass.pages.ProjectGlassPage;
import com.codecool.glass.pages.TestFestBugPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codecool.glass.utils.DriverSingleton.quitDriver;

public class BasicSummaryRegressionTest {

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
    public void isBasicSummaryPresent(){
        projectGlassPage.isElementPresentAndContainWord(projectGlassPage.basicSummary, "Basic Summary");}

    @Test
    public void isBasicSummaryProjectCardPresent(){
        projectGlassPage.isElementPresentAndContainWord(projectGlassPage.basicSummaryProjectCard, "Neo's choice");}

    @Test
    public void isKeyCardPresent(){
        projectGlassPage.isElementPresentAndContainWord(projectGlassPage.keyCard, "Key");
//        Assertions.assertTrue(keyCardText.contains("NC"));
    }

    @Test
    public void isCategoryCardPresent(){
        projectGlassPage.isElementPresentAndContainWord(projectGlassPage.categoryCard, "Category");
    }

    @Test
    public void isLeadCardPresent(){
        projectGlassPage.isElementPresentAndContainWord(projectGlassPage.leadCard, "Lead");
//        Assertions.assertTrue(leadCardText.contains("Codecool Admin"));
    }

    @Test
    public void defaultAssigneeCardPresent(){
        projectGlassPage.isElementPresentAndContainWord(projectGlassPage.defaultAssigneeCard, "Default assignee");
//        Assertions.assertTrue(d.contains("unassigned"));
    }
}
