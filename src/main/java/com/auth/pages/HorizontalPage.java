package com.auth.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalPage {
    private WebDriver driver;
    private By sliderValue = By.id("range");
    private By slider = By.cssSelector(".sliderContainer input");

    public HorizontalPage(WebDriver driver){
        this.driver = driver;
    }

    public void setSliderValue(String value){
        var find = driver.findElement(slider);
        while(!getSliderValue().equals(value)){
            find.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getSliderValue(){
        return driver.findElement(sliderValue).getText();
    }
}
