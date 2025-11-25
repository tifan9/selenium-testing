package wait;

import Base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WaitTest extends BaseTest {

    @Test
    public void testWaitUntilHidden(){
        var loadingPage = homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickStart();
        assertEquals(loadingPage.getLoadedText(), "Hello World!", "Loaded text is incorrect");


    }
}
