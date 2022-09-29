package com.codecool.glass.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GlassPageMatrix extends BasePage {
    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div/div[3]/div[4]/div/div/div[2]/div/table/tbody/tr[1]") public static WebElement initialRow;
    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div/div[3]/div[4]/div/div/div[2]/div/table/tbody/tr[2]") public static WebElement reusedRow;
    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div/div[3]/div[4]/div/div/div[2]/div/table/tbody/tr[4]") public static WebElement globalRow;
    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div/div[3]/div[4]/div/div/div[2]/div/table/tbody/tr[5]") public static WebElement uniqueRow;
    @FindBy(xpath = "//div[@role='tablist']") public static WebElement detailsPostCounter;
    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div/div[3]/div[4]/div/div/div[2]/div/table/tbody/tr[5]/td[8]/div") public static WebElement uniqueRowPostFunction;

    @FindBy(xpath = "//span[contains(text(),'Post Functions')]//parent::div[@role='tab'] ") public static WebElement postsDetails;
    @FindBy(xpath = "//div[@role='tabpanel']") public static WebElement detailsPostPanel;
    //@FindBy(xpath = "//thead") public static WebElement transitionHeader;List

    @FindBy(className = "css-1oc7v0j") private WebElement tutorialModal;
    @FindBy(css = "#jira > div.atlaskit-portal-container > div:nth-child(2) > div > div:nth-child(3) > div.css-1oc7v0j > div > div > div > div > div:nth-child(2) > button")
    private WebElement tutorialSkipButton;

    public String glassUrl = "projects/NC?selectedItem=com.metainf.jira.plugin:glass-project-documentation#/home/issueTypes/10000/transitions";

    public void skipTutorial(){
        waitUntilElementLoaded(tutorialModal);
        tutorialSkipButton.click();
    }
    public boolean HaveElement(WebElement element, String type) {
        waitUntilElementLoaded(element);
        return element.getText().contains(type);
    }

    public boolean IsMainPostCounter(int def, int custom){
        String defaultCounter = "Default "+def ;
        String customCounter = "Custom "+custom;
        waitUntilElementLoaded(uniqueRowPostFunction);
        return uniqueRowPostFunction.getText().contains(defaultCounter) && uniqueRowPostFunction.getText().contains(customCounter);
    }

    public boolean IsDetailsPostCounter(int posts) {
        waitUntilElementLoaded(uniqueRowPostFunction);
        uniqueRowPostFunction.click();
        String counter = "Post Functions "+posts ;
        waitUntilElementLoaded(detailsPostCounter);
        return detailsPostCounter.getText().contains(counter);
    }

    public void GoToPostDetails() {
        waitUntilElementLoaded(uniqueRowPostFunction);
        uniqueRowPostFunction.click();
        waitUntilElementLoaded(postsDetails);
        postsDetails.click();
    }

    public boolean HasPostFunction(String post) {
        return detailsPostPanel.getText().contains(post);
    }

    public boolean HasAllPostFunctions(int num) {
        return driver.findElements(By.className("condition-block")).size() == num;
    }

    public boolean IsColumn(String column) {
        waitUntilElementLoaded(driver.findElement(By.tagName("th")));
        for (WebElement e :driver.findElements(By.xpath("//th")))
            if (e.getText().contains(column))
                return true;
        return false;
    }

    private int CountColumn(String column) {
        int count = 0;
        waitUntilElementLoaded(driver.findElement(By.tagName("th")));
        for (WebElement e :driver.findElements(By.xpath("//th"))) {
            count++;
            if (e.getText().contains(column))
                return count;
        }
        return -1;
    }

    public boolean HasNameInTheTable(String name, String row, String column) {
        String path = "//strong[contains(text(),'" +row+ "')]/parent::span/parent::td/parent::tr/td["+CountColumn(column)+"]";
        waitUntilElementLoaded(driver.findElement(By.xpath(path)));
        WebElement elem = driver.findElement(By.xpath(path));
        return elem.getText().contains(name);
    }

}
