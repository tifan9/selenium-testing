package alerts;

import Base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertTest extends BaseTest {
    @Test
    public void testAcceptAlert(){
        var alertPage = homePage.clickJavascriptAlert();
        alertPage.triggerAlert();
        alertPage.acceptAlert();
        //compare the result
        assertEquals(alertPage.getResult(), "You successfully clicked an alert","Result text is incorrect");

    }
    @Test
    public void testCancelAlert(){
        var alertPage = homePage.clickJavascriptAlert();
        alertPage.triggerConfirm();
        alertPage.cancelAlert();
        assertEquals(alertPage.getResult(), "You clicked: Cancel", "Result text is incorrect");
    }

    @Test
    public void testPromptAlert(){
        var alertPage = homePage.clickJavascriptAlert();
        alertPage.triggerPrompt();
        String text = "Sophie";
        alertPage.setInputPrompt(text);
        alertPage.acceptAlert();
        assertEquals(alertPage.getResult(), "You entered: " + text, "Result text is incorrect");


    }
}
