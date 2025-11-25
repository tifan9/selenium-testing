package javascript;

import Base.BaseTest;
import org.testng.annotations.Test;

public class JavaScriptTest extends BaseTest {

    @Test
    public void testScrollToTable(){
        homePage.clickLargeDeepDom().scrollToTable();

    }

    @Test
    public void testScrollTpFifthParagraph(){
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }
}
