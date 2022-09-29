package com.codecool.glass.features;

import com.codecool.glass.pages.GlassPageMatrix;
import org.junit.jupiter.api.*;

import static com.codecool.glass.utils.DriverSingleton.quitDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LinksTests {
    private static GlassPageMatrix glassPage;

    @BeforeAll
    public void setUp() {
        glassPage = new GlassPageMatrix();
        glassPage.logIn();
        glassPage.openUrl(glassPage.glassEpicUrl);
        glassPage.skipTutorial();
    }
    @AfterEach
    public void GoBack(){
        glassPage.openUrl(glassPage.glassEpicUrl);
    }
    @AfterAll
    public void tearDown(){
        quitDriver();
    }

    @Test
    public void IsGeneralLinkInAdmin(){
        assertTrue(glassPage.HaveEnableElement("General"));
        glassPage.openUrl(glassPage.glassUrl);
        assertTrue(glassPage.HaveEnableElement("General"));
    }
    @Test
    public void IsComponentsLinkInAdmin(){
        assertTrue(glassPage.HaveEnableElement("Components"));
        glassPage.openUrl(glassPage.glassUrl);
        assertTrue(glassPage.HaveEnableElement("Components"));
    }
    @Test
    public void IsVersionsLinkInAdmin(){
        assertTrue(glassPage.HaveEnableElement("Versions"));
        glassPage.openUrl(glassPage.glassUrl);
        assertTrue(glassPage.HaveEnableElement("Versions"));
    }
    @Test
    public void IsWorkflowLinkInAdmin(){
        assertTrue(glassPage.HaveEnableElement("Workflow"));
        glassPage.openUrl(glassPage.glassUrl);
        assertTrue(glassPage.HaveEnableElement("Workflow"));
    }
    @Test
    public void IsScreensLinkInAdmin(){
        assertTrue(glassPage.HaveEnableElement("Screens"));
        glassPage.openUrl(glassPage.glassUrl);
        assertTrue(glassPage.HaveEnableElement("Screens"));
    }
    @Test
    public void IsPeopleLinkInAdmin(){
        assertTrue(glassPage.HaveEnableElement("People"));
        glassPage.openUrl(glassPage.glassUrl);
        assertTrue(glassPage.HaveEnableElement("People"));
    }
    @Test
    public void IsPermissionsLinkInAdmin(){
        assertTrue(glassPage.HaveEnableElement("Permissions"));
        glassPage.openUrl(glassPage.glassUrl);
        assertTrue(glassPage.HaveEnableElement("Permissions"));
    }
    @Test
    public void IsNotificationsLinkInAdmin(){
        glassPage.overflowMenu.click();
        assertTrue(glassPage.HaveEnableElement("Notifications"));
        glassPage.openUrl(glassPage.glassUrl);
        //glassPage.overflowMenu.click();
        assertTrue(glassPage.HaveEnableElement("Notifications"));
    }
    @Test
    public void IsChangeSchemeLinkInAdmin(){
        assertTrue(glassPage.HaveEnableElement("Change Scheme"));
        glassPage.openUrl(glassPage.glassUrl);
        assertTrue(glassPage.HaveEnableElement("Change Scheme"));
    }
}
