package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

/**
 * Navigate to <a href="https://www.w3schools.com/html/html_tables.asp">w3schools tables</a>
 * check that the Contact for "Alfreds Futterkiste" company is "Maria Anders"
 */

public class relativeExample {
    WebDriver driver;
//    @Test
//    public void checkNameOfFirstElement() {
//
//        Assertions.assertEquals("Maria Anders", index1(2));
//    }
//    @Test
//    public void checkNameOfFirstElement2() {
//        Assertions.assertEquals("Helen Bennett", index1(5));
//    }

    @Test
    public void checkContactNameForTargetCompany(){
        Assertions.assertEquals("Maria Anders", getContactName("Alfreds Futterkiste"));
    }

    @Test
    public void checkContactNameForTargetCompany2(){
        Assertions.assertEquals("Helen Bennett", getContactName("Island Trading"));
    }

    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
    }

    @AfterEach
    public void afterEach()
    {
        driver.quit();
    }
    private String getContactName(String targetCompany){
        By contactNameForTargetCompany = By.xpath("//tr[contains(.,'"+targetCompany+"')]/td[2]");
        return driver.findElement(contactNameForTargetCompany).getText();
    }

}
