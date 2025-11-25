package Base;

import com.auth.pages.HomePage;
import com.auth.utils.EventReporter;
import com.auth.utils.WindowManager;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.events.*;

public class BaseTest {
    private WebDriver driver;

    protected HomePage homePage;
    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriver rawDriver = new ChromeDriver();
        // wrap driver with EventFiringDecorator to get event firing behavior (Selenium 4)
        EventReporter eventListener = new EventReporter();
        driver = new EventFiringDecorator(eventListener).decorate(rawDriver);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        goHome();
//        After opening the application instantiate the homepage
        homePage = new HomePage((WebDriver) driver);
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
    // this runs after each test runs
    @AfterMethod
    public void recordFailure(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot) driver;
            File screenShot = camera.getScreenshotAs(OutputType.FILE);
            Files.move(screenShot , new File("resources/screenshots/" + result.getName() + ".png"));
            System.out.println("Screenshot saved at: " + screenShot.getAbsolutePath());
        }

    }
    // method to open multiple windows
    public WindowManager getWidowManager(){
        return new WindowManager(driver);
    }
}
