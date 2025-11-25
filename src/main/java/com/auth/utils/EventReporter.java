package com.auth.utils;
import org.openqa.selenium.support.events.WebDriverListener;

public class EventReporter implements WebDriverListener {
    @Override
    public void beforeClick(org.openqa.selenium.WebElement element) {
        System.out.println("Trying to click on: " + element);
    }
    @Override
    public void afterClick(org.openqa.selenium.WebElement element) {
        System.out.println("Clicked on: " + element);
    }
    @Override
    public void beforeGetText(org.openqa.selenium.WebElement element) {
        System.out.println("Trying to get text from: " + element);
    }
    @Override
    public void afterGetText(org.openqa.selenium.WebElement element, String result) {
        System.out.println("Got text: '" + result + "' from: " + element);
    }
}
