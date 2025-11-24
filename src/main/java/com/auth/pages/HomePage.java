package com.auth.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
//    private By formAuthenticationLink = By.linkText("Form Authentication");
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public LoginPage clickFormAuthentication(){
//        driver.findElement(formAuthenticationLink).click();
        clickLink("Form Authentication");
        return new LoginPage(driver);
    }
    public DropDownPage clickDropDown(){
        clickLink("Dropdown");
        return new DropDownPage(driver);
    }
    public HoversPage clickHovers(){
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    // key presses
    public KeyPressesPage clickKeyPresses(){
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }
// Exercise on horizontal slider
public HorizontalPage clickHorizontalSlider(){
    clickLink("Horizontal Slider");
    return new HorizontalPage(driver);
}

    // alert
    public AlertPage clickJavascriptAlert(){
        clickLink("JavaScript Alerts");
        return new AlertPage(driver);
    }

    // upload file
    public FileUploadPage clickFileUpload(){
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }

    // Context menu page
    public ContextMenuPage clickContextMenu(){
        clickLink("Context Menu");
        return new ContextMenuPage(driver);
    }




// generic link to
    public void clickLink (String linkTest){
        driver.findElement(By.linkText(linkTest)).click();
    }

//    Method for forget password
    public ForgotPasswordPage clickForgotPassword(){
        clickLink("Forgot Password");
        return new ForgotPasswordPage(driver);
    }








}
