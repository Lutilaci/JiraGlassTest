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
    @FindBy(css = "[class='css-1p25gik'] .css-t5emrf") public WebElement documentationButton;
    @FindBy(css = "#app-root [class='css-1p5j0a7'] .css-d6vpf6:nth-of-type(2) div") public WebElement sendUsFeedbackButton;
    @FindBy(css = "#app-root [class='css-1p5j0a7'] .highlight-holder .css-t5emrf") public WebElement exportAsButton;
    @FindBy(xpath = "/html//div[@id='app-root']/div/div//h3[.='Basic Summary']") public WebElement basicSummary;
    @FindBy(css = ".full-fixed-double-height.general-colored-border") public WebElement basicSummaryProjectCard;
    @FindBy(css = ".full-fixed-double-height .vertical-center > div:nth-child(2) > span:nth-of-type(1)") public WebElement projectCardTitle;
    @FindBy(css = "#app-root div:nth-child(3) .general-colored-border:nth-of-type(2)") public WebElement keyCard;
    @FindBy(css = "div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(3)") public WebElement categoryCard;
    @FindBy(css = "#app-root div:nth-child(3) .people-colored-border:nth-of-type(4)") public WebElement leadCard;
    @FindBy(css = "#app-root div:nth-child(3) .people-colored-border:nth-of-type(5)") public WebElement defaultAssigneeCard;


    public boolean isElementPResent(WebElement element){
        return element.isDisplayed();
    }




}
