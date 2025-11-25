package com.auth.utils;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.events.WebDriverEventListener;

public class WindowManager {
    private WebDriver driver;
    private WebDriver.Navigation navigate;
    public WindowManager(WebDriver driver){
        this.driver = driver;
        navigate = driver.navigate();
    }
    // method to go back
    public void goBack(){
        driver.navigate().back();
    }
    public void goForward(){
        navigate.forward();
    }
    public void refreshPage(){
        navigate.refresh();
    }
    public void gotTo(String url){
        navigate.to(url);
    }
    public void switchToTab(String tabTitle){
       var windows = driver.getWindowHandles();
        System.out.println("Number of tabs opened: " + windows.size());
        System.out.println("Windows handle: ");
        windows.forEach(System.out::println);

        // loop through all the window handles
        for(String window: windows){
            System.out.println("Switching to window: " + window);
            driver.switchTo().window(window);

            System.out.println("Current window title: " + driver.getTitle());

            if(tabTitle.equals(driver.getTitle())){
                break;
            }
        }
    }





}














