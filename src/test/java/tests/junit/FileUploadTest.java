package tests.junit;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

/**
 * Breakout Activity: 20 minute
 * navigate to <a href="https://the-internet.herokuapp.com/upload">Upload Test</a>
 * uploading any file from your machine (make it small please)
 * checking to see that the file was successfully uploaded
 */

public class FileUploadTest extends TestBase {

    @Test
    public void fileUpload(){
        String url= "https://the-internet.herokuapp.com/upload";
        logger.info("Navigating to:");
        driver.get(url);
//        driver.navigate().to("");
        By file= By.xpath("(//input[@type='file'])[1]");
        logger.info("uploading file:" +file);
        driver.findElement(file).sendKeys("C:/Users/Leen/IdeaProjects/TestSda1/src/test/java/testPackage/text.txt");
        driver.findElement(file).submit();

        By txt = By.tagName("h3");
        logger.info("confirm that the file was created successfully ");
        Assertions.assertEquals("File Uploaded!", driver.findElement(txt).getText());
    }
}
