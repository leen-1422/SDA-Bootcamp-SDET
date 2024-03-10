package testPackage;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




//Task 1:
//Go to URL: https://demoqa.com/radio-button
//Verify whether all 3 options given to the question can be selected.
//When each option is selected, print the following texts on the console.



public class testClass {
    WebDriver driver;
    @Test
    public void radio1(){
        By radio1 = By.xpath("//label[@class='custom-control-label' and @for='yesRadio']");
        driver.findElement(radio1).click();

        By radioInput = By.id("yesRadio");
        boolean isOption1Selected = driver.findElement(radioInput).isSelected();

       Assertions.assertTrue(isOption1Selected);
        String actualMsg = driver.findElement(By.xpath("//p[@class='mt-3']")).getText();
        Assertions.assertEquals( "You have selected Yes", actualMsg);

        System.out.println(actualMsg);
    }


    @Test
    public void radio2(){
        By radio2 = By.xpath("//label[@class='custom-control-label' and @for='impressiveRadio']");
        driver.findElement(radio2).click();

        By radioInput = By.id("impressiveRadio");
        boolean isOption1Selected = driver.findElement(radioInput).isSelected();

        Assertions.assertTrue(isOption1Selected);
        String actualMsg = driver.findElement(By.xpath("//p[@class='mt-3']")).getText();
        Assertions.assertEquals( "You have selected Impressive", actualMsg);
        System.out.println(actualMsg);
    }
    @Test
    public void radio3(){
        By radio1 = By.id("noRadio");
        boolean isOption1Enabled = driver.findElement(radio1).isEnabled();
        Assertions.assertFalse(isOption1Enabled);
    }
    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/radio-button");
    }
    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
