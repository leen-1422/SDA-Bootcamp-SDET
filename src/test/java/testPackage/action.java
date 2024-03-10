package testPackage;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * Breakout task: 15 minutes
 * Navigate to <a href="https://the-internet.herokuapp.com/javascript_alerts">Alerts</a>
 * click on "Click for JS Confirm"
 * Press OK
 * Check that "You clicked: Ok" is displayed
 */

public class action extends TestBase {


    @Test
    public void alertActions(){

        // //button[contains(@onclick,'jsConfirm()')]
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        By confermButton = By.xpath("//button[contains(@onclick,'jsConfirm()')]");
        driver.findElement(confermButton).click();


        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        By txt= By.id("result");
        var actTxt= driver.findElement(txt).getText();

        Assertions.assertEquals("You clicked: Ok", actTxt);

    }

    @Test
    public  void frames(){
        driver.navigate().to("https://www.selenium.dev/selenium/web/click_frames.html");
        WebElement iframe = driver.findElement(By.xpath("//frame[@name='source']"));

        driver.switchTo().frame(iframe);

        var txt = driver.findElement(By.tagName("h1")).getText();
        Assertions.assertEquals("Testing Clicks", txt);
        driver.switchTo().defaultContent();

    }


}
