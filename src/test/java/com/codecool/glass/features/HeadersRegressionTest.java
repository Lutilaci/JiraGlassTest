package com.codecool.glass.features;

import com.codecool.glass.pages.ProjectGlassPage;
import com.codecool.glass.pages.TestFestBugPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codecool.glass.utils.DriverSingleton.quitDriver;

public class HeadersRegressionTest {
    private ProjectGlassPage projectGlassPage;
    private TestFestBugPage testFestBugPage;

    @BeforeEach
    public void setUp() {
        projectGlassPage = new ProjectGlassPage();
        testFestBugPage = new TestFestBugPage();
        projectGlassPage.logIn();
        projectGlassPage.openUrl("/projects/NC?selectedItem=com.metainf.jira.plugin:glass-project-documentation#/home/general/schemes");
        testFestBugPage.skipTutorial();
    }

    @AfterEach
    public void tearDown(){
        quitDriver();
    }

    @Test
    public void checkHeader(){
        boolean isPresent = false;
        List<WebElement> headerButtons = new ArrayList<>();

        headerButtons.add(projectGlassPage.generalButton);
        headerButtons.add(projectGlassPage.issueTypeButton);
        headerButtons.add(projectGlassPage.peopleButton);
        headerButtons.add(projectGlassPage.permissionsButton);
        headerButtons.add(projectGlassPage.notificationsButton);

    }
}
