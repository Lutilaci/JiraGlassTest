package com.codecool.glass.features;

import com.codecool.glass.pages.GlassPageMatrix;
import com.codecool.glass.pages.ProjectGlassPage;
import com.codecool.glass.pages.TestFestBugPage;
import org.junit.jupiter.api.*;

import static com.codecool.glass.utils.DriverSingleton.quitDriver;

public class HeadersRegressionTest {
    private static  ProjectGlassPage projectGlassPage;
    private static TestFestBugPage testFestBugPage;
    private static GlassPageMatrix glassPageMatrix;

    @BeforeAll
    public static void setUp() {
        projectGlassPage = new ProjectGlassPage();
        testFestBugPage = new TestFestBugPage();
        glassPageMatrix = new GlassPageMatrix();
        projectGlassPage.logIn();
        projectGlassPage.openUrl("/projects/NC?selectedItem=com.metainf.jira.plugin:glass-project-documentation#/home/general/schemes");
        testFestBugPage.skipTutorial();
    }

    @AfterAll
    public static void tearDown(){
        quitDriver();
    }

    @Test
    public void checkHeaderGeneralExist(){
//        boolean isPresent = false;
//        List<WebElement> headerButtons = new ArrayList<>();
//
//        headerButtons.add(projectGlassPage.generalButton);
//        headerButtons.add(projectGlassPage.issueTypeButton);
//        headerButtons.add(projectGlassPage.peopleButton);
//        headerButtons.add(projectGlassPage.permissionsButton);
//        headerButtons.add(projectGlassPage.notificationsButton);

        glassPageMatrix.HaveElement(projectGlassPage.generalButton, "General");
    }

    @Test
    public void checkHeaderIssueTypesButtonExist(){glassPageMatrix.HaveElement(projectGlassPage.generalButton, "Issue Types");}

    @Test
    public void checkHeaderPeopleButtonExist(){glassPageMatrix.HaveElement(projectGlassPage.peopleButton, "People");}

    @Test
    public void checkHeaderPermissionsButtonExist(){glassPageMatrix.HaveElement(projectGlassPage.generalButton, "Permissions");}

    @Test
    public void checkHeaderNotificationsButtonExist(){glassPageMatrix.HaveElement(projectGlassPage.generalButton, "Notifications");}

    @Test
    public void checkHeaderDocumentationButtonExist(){glassPageMatrix.HaveElement(projectGlassPage.generalButton, "Documentation");}

    @Test
    public void checkHeaderSendUsFeedbackButtonExist(){glassPageMatrix.HaveElement(projectGlassPage.generalButton, "Send us feedback");}

    @Test
    public void checkHeaderExportAsButtonExist(){glassPageMatrix.HaveElement(projectGlassPage.generalButton, "Export as");}

}
