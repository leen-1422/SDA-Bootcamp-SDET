package tests.Assignments;




//Go back to the previous window and then verify the title: “The Internet”

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.asserts.Assertion;
import tests.junit.TestBase;

import java.util.Set;

public class assignment2_getTitle extends TestBase {
    @Test
    public void titleTest(){
        driver.navigate().to("https://the-internet.herokuapp.com/windows");

        var header = driver.findElement(By.tagName("h3")).getText();
        Assertions.assertEquals("Opening a new window", header);
        var title = driver.getTitle();
        Assertions.assertEquals("The Internet", title);
        var button = driver.findElement(By.xpath("//a[contains(@href,'new')]"));
        var originalWindowHandle = driver.getWindowHandle();

        button.click();

        Set<String > handles = driver.getWindowHandles();
        handles.remove(originalWindowHandle);
        String newWindowHandle = (String) handles.toArray()[0];
        driver.switchTo().window(newWindowHandle);

        driver.getTitle();
        var newHeader = driver.findElement(By.tagName("h3")).getText();
        Assertions.assertEquals("New Window", newHeader);

        driver.switchTo().window(originalWindowHandle);
        var newtitle = driver.getTitle();
        Assertions.assertEquals("The Internet", newtitle);

    }




}
