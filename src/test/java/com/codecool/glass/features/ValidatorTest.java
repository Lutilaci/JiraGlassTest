package com.codecool.glass.features;

import com.codecool.glass.pages.TestFestBugPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    private static TestFestBugPage testFestBugPage;

    @BeforeEach
    public void setUp(){
        testFestBugPage = new TestFestBugPage();
        testFestBugPage.logIn();
        testFestBugPage.openUrl("/projects/JIR?selectedItem=com.metainf.jira.plugin:glass-project-documentation#/home/issueTypes/10004/transitions");
        testFestBugPage.skipTutorial();
        testFestBugPage.goSendToReviewTransition();
    }

    @Test
    public void counterCountSuccessful(){
        String counter = "2";
        Assertions.assertTrue(testFestBugPage.correctValidationCounters(counter));
    }

    @Test
    public void correctValidatorsListed(){
        String validator1 = "Validates that work have been logged in the issue.";
        String validator2 = "Only users with Administer Projects permission can execute this transition.";
        testFestBugPage.goToValidators();
        Assertions.assertEquals(validator1,testFestBugPage.correctValidator1());
        Assertions.assertEquals(validator2,testFestBugPage.correctValidator2());
    }
}
