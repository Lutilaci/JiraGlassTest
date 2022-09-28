package com.codecool.glass.features;

import com.codecool.glass.pages.TestFestBugPage;
import org.junit.jupiter.api.*;

import static com.codecool.glass.utils.DriverSingleton.quitDriver;

public class ConditionsTest {
    private static TestFestBugPage testFestBugPage;


    @BeforeEach
    public void setUp() {
        testFestBugPage = new TestFestBugPage();
        testFestBugPage.logIn();
        testFestBugPage.openUrl("/projects/JIR?selectedItem=com.metainf.jira.plugin:glass-project-documentation#/home/issueTypes/10004/transitions");
        testFestBugPage.skipTutorial();
        testFestBugPage.goSendToReviewTransition();
    }

    @AfterEach
    public void tearDown(){
        quitDriver();
    }

    @Test
    public void counterCountSuccessful(){
        String counter = "3";
        Assertions.assertTrue(testFestBugPage.correctConditionsCounters(counter));
    }

    @Test
    public void validatorsCorrectlyShow(){
        String firstCondition = "ALL";
        String secondCondition = "ANY";
        testFestBugPage.goToConditions();
        Assertions.assertEquals(firstCondition, testFestBugPage.firstCondition());
        Assertions.assertEquals(secondCondition,testFestBugPage.secondCondition());
    }

    @Test
    public void nestedConditionsCorrectlyShow(){
        String condition1 = "This transition will only execute if code has been committed against this issue.";
        String condition2 = "All sub-tasks must have one of the following statuses to allow parent issue transitions: IN REVIEW";
        String condition3 = "Transition will only be available on issues that matches against the given JQL.";
        testFestBugPage.goToConditions();
        Assertions.assertEquals(condition1, testFestBugPage.correctCondition1());
        Assertions.assertEquals(condition2, testFestBugPage.correctCondition2());
        Assertions.assertEquals(condition3, testFestBugPage.correctCondition3());
    }
}
