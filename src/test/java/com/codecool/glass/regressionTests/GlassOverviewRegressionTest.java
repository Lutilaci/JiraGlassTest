package com.codecool.glass.regressionTests;

import com.codecool.glass.pages.ProjectGlassPage;
import com.codecool.glass.pages.TestFestBugPage;
import org.junit.jupiter.api.AfterAll;
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
    public void isGlassOverviewPresent() {
        projectGlassPage.isElementPresentAndContainWord(projectGlassPage.glassOverview, "Glass Overview");
    }

    @Test
    public void isLastIssueCreatedCardPresent(){
        projectGlassPage.isElementPresentAndContainWord(projectGlassPage.lastIssueCreatedCard, "Last issue created");}

    @Test
    public void isWorkflowsCardPresent(){
        projectGlassPage.isElementPresentAndContainWord(projectGlassPage.workflowsCard, "Workflows");}

    @Test
    public void isComponentsCardPresent(){
        projectGlassPage.isElementPresentAndContainWord(projectGlassPage.componentsCard, "Components");}

    @Test
    public void isVersionsCardPresent(){
        projectGlassPage.isElementPresentAndContainWord(projectGlassPage.versionsCard, "Versions");}

    @Test
    public void isAccessOverviewCardPresent(){
        projectGlassPage.isElementPresentAndContainWord(projectGlassPage.accessOverviewCard, "Access Overview");}
}
