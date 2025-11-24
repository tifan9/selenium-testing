package com.auth.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage {
    private WebDriver driver;
    private By triggerAlertButton = By.xpath(".//button[text()='Click for JS Alert']");
    private By triggerConfirmButton = By.xpath(".//button[text()='Click for JS Confirm']");
    private By triggerPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");
    private By result = By.id("result");
    public AlertPage(WebDriver driver){
        this.driver = driver;
    }

    // click the button for trigger
    public void triggerAlert(){
        driver.findElement(triggerAlertButton).click();
    }
    public void triggerConfirm(){
        driver.findElement(triggerConfirmButton).click();
    }
    public void cancelAlert(){
        driver.switchTo().alert().dismiss();
    }
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void triggerPrompt(){
        driver.findElement(triggerPromptButton).click();
    }
    public void setInputPrompt(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    public String getResult(){
        return driver.findElement(result).getText();
    }

}
