package com.auth.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DropDownPage {

    private WebDriver driver;
    private By dropdown = By.id("dropdown");
    public DropDownPage(WebDriver driver){
        this.driver = driver;
    }
    public void selectFromDropDown(String option){
        findDropdownElement().selectByVisibleText(option);
    }
    public List<String> getSelectedOption(){
        List<WebElement> selectedElements =
        findDropdownElement().getAllSelectedOptions();
        return selectedElements.stream().map(WebElement::getText).collect(Collectors.toList());

    }
private Select findDropdownElement(){
        return new Select(driver.findElement(dropdown));
}
}
