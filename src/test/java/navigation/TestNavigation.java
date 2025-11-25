package navigation;

import Base.BaseTest;
import org.testng.annotations.Test;

public class TestNavigation extends BaseTest {

    @Test
    public void testNavigation(){
        homePage.clickDynamicLoading().clickExample1();
        getWidowManager().goBack();
        getWidowManager().refreshPage();
        getWidowManager().goForward();
        getWidowManager().gotTo("https://google.com");
    }
    @Test
    public void testSwitchTab(){
        homePage.clickMultipleWindows().clickHere();
        getWidowManager().switchToTab("New Window");
    }
}
