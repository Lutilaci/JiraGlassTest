package com.codecool.glass.regressionTests;

import com.codecool.glass.pages.GlassPageMatrix;
import com.codecool.glass.pages.ProjectGlassPage;
import com.codecool.glass.pages.TestFestBugPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
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
        projectGlassPage.isElementPResent(projectGlassPage.basicSummary);
        Assertions.assertEquals(projectGlassPage.getElementText(projectGlassPage.basicSummary), "Basic Summary");
    }

    @Test
    public void isBasicSummaryProjectCardPresent(){
        projectGlassPage.isElementPResent(projectGlassPage.basicSummaryProjectCard);
        Assertions.assertEquals(projectGlassPage.getElementText(projectGlassPage.projectCardTitle), "Neo's choice");
    }

    @Test
    public void isKeyCardPresent(){
        projectGlassPage.isElementPResent(projectGlassPage.keyCard);
        String keyCardText = projectGlassPage.keyCard.getText();
        Assertions.assertTrue(keyCardText.contains("Key"));
//        Assertions.assertTrue(keyCardText.contains("NC"));
    }

    @Test
    public void isCategoryCardPresent(){
        projectGlassPage.isElementPResent(projectGlassPage.categoryCard);
    }

    @Test
    public void isLeadCardPresent(){
        projectGlassPage.isElementPResent(projectGlassPage.leadCard);
        String leadCardText = projectGlassPage.leadCard.getText();
        Assertions.assertTrue(leadCardText.contains("Lead"));
//        Assertions.assertTrue(leadCardText.contains("Codecool Admin"));
    }

    @Test
    public void defaultAssigneeCardPresent(){
        projectGlassPage.isElementPResent(projectGlassPage.defaultAssigneeCard);
        String defaultAssigneeCardText = projectGlassPage.defaultAssigneeCard.getText();
        Assertions.assertTrue(defaultAssigneeCardText.contains("Default assignee"));
//        Assertions.assertTrue(leadCardText.contains("unassigned"));
    }
}
