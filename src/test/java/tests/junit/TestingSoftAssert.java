package tests.junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

/**
 * Breakout session: 30 minutes
 * navigate to https://practicetestautomation.com/practice-test-login/
 * login using "Username": "student" + "Password": "Password123" (using testdata.json is optional)
 * check that the url is correct "https://practicetestautomation.com/logged-in-successfully/"
 * check the successful login, congratulations message, and logout button are displayed
 */

public class TestingSoftAssert extends TestBase{

        @Test
        public void softA(){
            driver.navigate().to("https://practicetestautomation.com/practice-test-login/");

            By username = By.id("username");
            By password = By.id("password");
            By button = By.id("submit");

            driver.findElement(username).sendKeys("student");
            driver.findElement(password).sendKeys("Password123");
            driver.findElement(button).click();


            By lable = By.className("post-title");
            By msg = By.tagName("strong");
            By logoutbutton = By.xpath("//a[contains(@href,'practice-test-login')]");

            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/");
            softAssert.assertTrue(driver.findElement(lable).isDisplayed());
            softAssert.assertTrue(driver.findElement(msg).isDisplayed());
            softAssert.assertTrue(driver.findElement(logoutbutton).isDisplayed());
          softAssert.assertAll();





    }
}
