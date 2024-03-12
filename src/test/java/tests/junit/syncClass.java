package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Use Google Chrome
 * Navigate to <a href="https://www.google.com/">Google.com</a>
 * Search for "Selenium"
 * Check that results stats is not empty
 * Change to using Firefox
 */

public class syncClass {
    WebDriver driver;
    Wait<WebDriver> wait;

    @Test
    public void searchNotEmpty(){
        driver.navigate().to("https://www.google.com/");
        By search = By.id("APjFqb");
        driver.findElement(search).sendKeys("Selenium" + Keys.RETURN);

        By result = By.id("result-stats");
        //wait.until(d -> revealed.isDisplayed());
        String actualTxt= driver.findElement(result).getText();
        Assertions.assertNotEquals("", actualTxt);

    }


    @BeforeEach
    public void beforeEach(){

        driver = new FirefoxDriver();
        // impicit
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));


//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("start-maximized");
//        driver = new ChromeDriver(chromeOptions);

    }

    @AfterEach
    public void afterEach(){
        driver.quit();

    }
}
