package com.codecool.glass.pages;


import com.codecool.glass.utils.DriverSingleton;
import com.codecool.glass.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    private final Duration WAIT_DURATION = Duration.ofSeconds(3);
    private static String BASE_URL = Utils.getEnvironmentVariable("BASE_URL");
    private static String USER_NAME = Utils.getEnvironmentVariable("USER_NAME");
    private static String PASSWORD = Utils.getEnvironmentVariable("PASSWORD");

    public BasePage(){
        driver = DriverSingleton.getDriver();
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, WAIT_DURATION);
        driver.manage().window().maximize();
    }

    public void logIn(){
        openUrl("/login.jsp");
        driver.findElement(By.id("login-form-username")).sendKeys(USER_NAME);
        driver.findElement(By.id("login-form-password")).sendKeys(PASSWORD);
        driver.findElement(By.id("login-form-password")).submit();
    }

    public void waitUntilElementLoaded(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitUntilElementClickable(WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void openUrl(String url){
        driver.get(BASE_URL+url);
    }

    public boolean elementIsPresent(WebElement webElement){
       waitUntilElementLoaded(webElement);
       return webElement.isDisplayed();
    }
}