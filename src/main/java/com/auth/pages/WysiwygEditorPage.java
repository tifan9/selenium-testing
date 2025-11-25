package com.auth.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {
    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By decreaseIndentationButton = By.cssSelector("#mceu_12 button");
    public WysiwygEditorPage(WebDriver driver){
        this.driver = driver;
    }
    public void clearTextArea(){
        switchToEditorArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }
    // pass text in the text area
    public void setTextArea(String text){
        switchToEditorArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    public String getTextFromEditor(){
        switchToEditorArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }
    public void decreaseIndentation(){
        driver.findElement(decreaseIndentationButton).click();
    }
    private void switchToEditorArea(){
        driver.switchTo().frame(editorIframeId);
    }

    // exit out of the iframe
    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }







}







