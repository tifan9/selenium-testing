package com.auth.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailSentPage {
    private final WebDriver driver;
    private final By contentArea = By.id("content");
    public EmailSentPage(WebDriver driver){
        this.driver = driver;
    }

    public String getMessage(){
        return driver.findElement(contentArea).getText();
    }

}
