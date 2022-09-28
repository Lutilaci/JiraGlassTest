package com.codecool.glass.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.Key;

public class TestFestBugPage extends BasePage {

    //sendToReview Transitions

    @FindBy(css = "#jira > div.atlaskit-portal-container > div:nth-child(2) > div > div:nth-child(3) > div.css-79ym8r > div > div > div > div > div:nth-child(1) > div > div > table > tbody > tr > td:nth-child(6) > div > span > span")
    private WebElement detailsConditionCounter;

    @FindBy(css = "#jira > div.atlaskit-portal-container > div:nth-child(2) > div > div:nth-child(3) > div.css-79ym8r > div > div > div > div > div:nth-child(2) > div > div > div.sc-dVhcbM.KPvEY > div > div:nth-child(2) > span > span")
    private WebElement detailsConditionMenuCounter;

    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div/div[3]/div[4]/div/div/div[2]/div/table/tbody/tr[3]")
    private WebElement sendToReviewTransition;

    @FindBy(className = "css-1oc7v0j")
    private WebElement tutorialModal;

    @FindBy(css = "#jira > div.atlaskit-portal-container > div:nth-child(2) > div > div:nth-child(3) > div.css-1oc7v0j > div > div > div > div > div:nth-child(2) > button")
    private WebElement tutorialSkipButton;

    public boolean correctConditionsCounters(String counter){
        waitUntilElementLoaded(detailsConditionCounter);
        return detailsConditionCounter.getText().equals(counter)
                && detailsConditionMenuCounter.getText().equals(counter);
    }

    public void goSendToReviewTransition(){
        waitUntilElementClickable(sendToReviewTransition);
        sendToReviewTransition.click();
    }

    public void skipTutorial(){
        waitUntilElementLoaded(tutorialModal);
        tutorialSkipButton.click();
    }

}
