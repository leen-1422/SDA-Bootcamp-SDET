package tests.testng;


import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softA extends Tests {
    @Test
    public void softA() {
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