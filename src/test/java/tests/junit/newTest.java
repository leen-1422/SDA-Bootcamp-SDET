package tests.junit;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * initialize the browser in maximized mode (using options)
 * navigate to <a href="https://www.selenium.dev/selenium/web/web-form.html">web form test page</a>
 * check the box and validate that it is checked
 * select the radio and validate that it is selected
 * choose an item (by value) from the select dropdown menu and validate that it is selected (by text)
 */
public class newTest {

    WebDriver driver;
    @Test
    public void radio1(){
        By radio1 = By.id("my-radio-1");
        driver.findElement(radio1).click();
        boolean isOption1Selected = driver.findElement(radio1).isSelected();
        Assertions.assertTrue(isOption1Selected);
    }

    @Test
    public void checkbox(){
        By cheackbox1 = By.id("my-check-2");
        driver.findElement(cheackbox1).click();

        boolean isOption1Selected = driver.findElement(cheackbox1).isSelected();
        Assertions.assertTrue(isOption1Selected);
    }

    @Test
    public void checkbox2(){
        By cheackbox2 = By.id("my-check-2");
        driver.findElement(cheackbox2).click();
        driver.findElement(cheackbox2).click();


        boolean isOption1Selected = driver.findElement(cheackbox2).isSelected();
        Assertions.assertFalse(isOption1Selected);
    }



    @Test
    public void dropDown(){
        By selectElement = By.name("my-select");
        Select select = new Select(driver.findElement(selectElement));
        select.selectByValue("2");
        String actText = select.getAllSelectedOptions().getFirst().getText();
        Assertions.assertEquals("Two", actText);
    }

    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @AfterEach
    public void afterEach(){

        driver.quit();
    }
}
