package com.auth.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage {
    private WebDriver driver;
    private By inputField = By.id("target");
    private By resultText = By.id("result");
    public KeyPressesPage(WebDriver driver){
        this.driver = driver;
    }

    // Method to set the characters in the input field
    public void enterText(String text){
        driver.findElement(inputField).sendKeys(text);
    }

    // method to enter π
    public void enterPi(){
        enterText(Keys.chord(Keys.ALT, "p") + "=3.14");
    }

    public String getResult(){
        return driver.findElement(resultText).getText();
    }

}
