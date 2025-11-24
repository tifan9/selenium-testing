package dropdown;

import Base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DropdownTest extends BaseTest {
    @Test
    public void testSelectOption(){
        var dropdownPage = homePage.clickDropDown();
        String option = "Option 1";
        dropdownPage.selectFromDropDown(option);
        var selectedOptions = dropdownPage.getSelectedOption();
        // assert that the only thing selected
        assertEquals(selectedOptions.size(),1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option),"Option not selected");
    }
}
