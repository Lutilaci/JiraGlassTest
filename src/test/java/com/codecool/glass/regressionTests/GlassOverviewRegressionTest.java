package com.codecool.glass.regressionTests;

import com.codecool.glass.pages.ProjectGlassPage;
import com.codecool.glass.pages.TestFestBugPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codecool.glass.utils.DriverSingleton.quitDriver;

public class GlassOverviewRegressionTest {

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
    public void isGlassOverviewPresent(){
        projectGlassPage.isElementPResent(projectGlassPage.glassOverview);
        Assertions.assertTrue(projectGlassPage.getElementText(projectGlassPage.glassOverview).contains("Glass Overview"));
        System.out.println(projectGlassPage.getElementText(projectGlassPage.glassOverview));
    }

    @Test
    public void isLastIssueCreatedCardPresent(){
        projectGlassPage.isElementPResent(projectGlassPage.lastIssueCreatedCard);
        Assertions.assertTrue(projectGlassPage.getElementText(projectGlassPage.lastIssueCreatedCard).contains("Last issue created"));
    }

    @Test
    public void isWorkflowsCardPresent(){
        projectGlassPage.isElementPResent(projectGlassPage.workflowsCard);
        Assertions.assertTrue(projectGlassPage.getElementText(projectGlassPage.workflowsCard).contains("Workflows"));
    }

    @Test
    public void isAccessOverviewCardPresent(){
        projectGlassPage.isElementPResent(projectGlassPage.accessOverviewCard);
        Assertions.assertTrue(projectGlassPage.getElementText(projectGlassPage.accessOverviewCard).contains("Access Overview"));
    }
}
