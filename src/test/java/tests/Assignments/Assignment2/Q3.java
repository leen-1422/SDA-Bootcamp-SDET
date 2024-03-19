package tests.Assignments.Assignment2;

/* go to "https://practicetestautomation.com/practice-test-login/"
enter username - "student"
enter password - "incorrectPassword"
and login
SOFT ASSERT the error message shown
SOFT ASSERT the error message is "Your password is invalid!"
*/

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.testng.Tests;

public class Q3 extends Tests {
    @Test
    public void softAssertionsHMQ(){
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        By username= By.id("username");
        By password= By.id("password");
        By login = By.id("submit");

        driver.findElement(username).sendKeys("student");
        driver.findElement(password).sendKeys("incorrectPassword");
        driver.findElement(login).click();

        By msg = By.className("show");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(msg).isDisplayed());
        softAssert.assertEquals(driver.findElement(msg).getText(),"Your password is invalid!");
        softAssert.assertAll();


    }

}
