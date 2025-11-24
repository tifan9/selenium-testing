package upload;

import Base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTest extends BaseTest {
    @Test
    public void testFileUpload(){
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("/Users/mac/Documents/Projects/TheGym/Selenium_Testing/src/main/resources/UplodFile");
        assertEquals(uploadPage.getUploadedFiles(),"UplodFile","Uploaded file name is incorrect");
    }
}
