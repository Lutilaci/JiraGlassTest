package com.codecool.glass.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectGlassPage extends BasePage{

    @FindBy(xpath = "//h1[text()=\"Neo's choice\"]") public WebElement projectName;
    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div/div[2]/header/nav/div/div[1]/div/button") public WebElement generalButton;
    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div/div[2]/header") public WebElement projectHeader;
    @FindBy(css = "#app-root nav .css-d6vpf6:nth-of-type(2) div") public WebElement issueTypeButton;
    @FindBy(css = "#app-root div:nth-of-type(2) .css-d6vpf6:nth-of-type(3) .css-t5emrf") public WebElement peopleButton;
    @FindBy(css = "#app-root .css-d6vpf6:nth-of-type(4) .css-t5emrf") public WebElement permissionsButton;
    @FindBy(css = "#app-root .css-d6vpf6:nth-of-type(5) .css-t5emrf") public WebElement notificationsButton;

    public boolean isElementPResent(WebElement element){
        return element.isDisplayed();
    }




}
