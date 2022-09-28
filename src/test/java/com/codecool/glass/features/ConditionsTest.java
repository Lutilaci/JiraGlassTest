package com.codecool.glass.features;

import com.codecool.glass.pages.TestFestBugPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConditionsTest {
    private static TestFestBugPage testFestBugPage;


    @BeforeAll
    public static void setUp(){
        testFestBugPage = new TestFestBugPage();
    }


    @Test
    public void login(){
        testFestBugPage.logIn();
    }
}
