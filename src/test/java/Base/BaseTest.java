package Base;

import com.auth.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        goHome();
//        After opening the application instantiate the homepage
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }
//    execute
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
