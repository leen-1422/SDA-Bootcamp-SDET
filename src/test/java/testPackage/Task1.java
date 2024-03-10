package testPackage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// 1. class level

// 2. BeforeAll

// 3. BeforeEach
// 4. testMethod1
// 5. AfterEach

// 6. BeforeEach
// 7. testMethod2
// 8. AfterEach

// 9. AfterAll




public class Task1 {
    WebDriver driver;


//    @Test
//    public void checkPageTitle(){
//        //checkpoint
//        var title = driver.getTitle();
//        Assertions.assertEquals("DuckDuckGo — Privacy, simplified.", title);
//    }
//    @Test
//    public void checkPageUrl(){
//        //checkpoint
//        var currentUrl = driver.getCurrentUrl();
//        Assertions.assertEquals("https://duckduckgo.com/", currentUrl);
//    }
    @Test
    public void webFormTest(){

       driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
        // input text
       By tesxtInput1 = By.id("my-text-id");
        driver.findElement(tesxtInput1).sendKeys("T1");

        By tesxtInput2 = By.name("my-password");
        driver.findElement(tesxtInput2).sendKeys("T2");

        By textInput3 = By.name("my-textarea");
        driver.findElement(textInput3).sendKeys("T3");

        // radio buttons
        By radio1 = By.id("my-radio-1");
        driver.findElement(radio1).click();

        By radio2 = By.id("my-radio-2");
        driver.findElement(radio2).click();

        // checkboxes

        By cheackbox1 = By.id("my-check-1");
        driver.findElement(cheackbox1).click();


        By cheackbox2 = By.id("my-check-2");
        driver.findElement(cheackbox2).click();




    }
@BeforeEach
   public void taskMethod(){
        driver = new ChromeDriver();
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
        // driver.navigate().to("https://www.facebook.com/");
}


@AfterEach
public void afterEach(){
        driver.close();
    }
}

