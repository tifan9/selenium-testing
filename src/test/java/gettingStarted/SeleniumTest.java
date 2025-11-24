package gettingStarted;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {
    public static void main (String [] args){
        System.out.println("Testing ");

//        1. Create a WebDriver with ChromeDriver object
//        2. Launch the browser
        WebDriver driver = new ChromeDriver();

//        3. Navigate to a specific URL
        driver.navigate().to("http://eaapp.somee.com");

//       Call Login Operation
        Login(driver);
// create user
        CreateUser(driver);

//Log out a user
        LogOff(driver);



    }

    public static void Login(WebDriver driver){
//        Finding the element using the By locator & clicking on that element using WebDriver
        driver.findElement(By.linkText("Login")).click();

        // Enter username and  password
        driver.findElement(By.name("UserName")).sendKeys("admin");
        driver.findElement(By.name("Password")).sendKeys("password");

        // clicking the login button
        driver.findElement(By.cssSelector(".btn")).submit();


    }
//    Create user method
public static void CreateUser(WebDriver driver){
//        Click the employee list
    driver.findElement(By.linkText("Employee List")).click();
    driver.findElement(By.linkText("Create New")).click();
    driver.findElement(By.name("Name")).sendKeys("AutoUser1_Tf");
    driver.findElement(By.id("DurationWorked")).sendKeys("50");
    Select selectGrade = new Select(driver.findElement(By.id ("Grade")));
    selectGrade.selectByVisibleText("Middle");
    driver.findElement(By.name("Email")).sendKeys("AutoUser1Tf@ea.com");

    driver.findElement(By.cssSelector(".btn")).click();
//    If the mandatory field error  of salary  appears, then  enter the salary
    if(driver.findElement(By.xpath("//span[text()='The Salary field is required.']")).isDisplayed()){
        driver.findElement(By.name("Salary")).sendKeys("1054300");
        driver.findElement(By.cssSelector(".btn")).click();

    }else{
        // do nothing
        System.out.println("Nothing being displayed ");
    }


}

public static void LogOff(WebDriver driver){
        driver.findElement(By.linkText("Log off")).click();

}
}
