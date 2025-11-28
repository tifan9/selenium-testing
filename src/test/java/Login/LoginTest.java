package Login;

import Base.BaseTest;
import com.auth.pages.LoginPage;
import com.auth.pages.SecureAreaPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {
    @Test
    public void testSuccessfullLogin() throws InterruptedException {
        Thread.sleep(2000);
       LoginPage loginPage = homePage.clickFormAuthentication();
       loginPage.setUsername("tomsmith");
       loginPage.setPassword("SuperSecretPassword!");
       SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
       assertTrue(secureAreaPage
               .getAlertText()
               .contains("You logged into a secure area!"),"Alert text is incorrect");
       // add an assertion tool

    }
}
