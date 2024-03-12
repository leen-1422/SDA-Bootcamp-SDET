package tests.junit;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Navigate to <a href="https://www.saucedemo.com/v1/index.html">SauceDemo</a>
 * login as standard_user
 * assert that there are 6 items on the products list page
 * add the first and last items to the cart
 * navigate to the cart and check that both items are listed
 */

public class Testcase {
    WebDriver driver;

    @Test
    public void checkTheProductList() {

//        // input text
        By userName = By.id("user-name");
        driver.findElement(userName).sendKeys("standard_user");

        By password = By.id("password");
        driver.findElement(password).sendKeys("secret_sauce");

        var loginButton = By.id("login-button");
        driver.findElement(loginButton).click();

        By items = By.className("inventory_item");
       var actualItems =  driver.findElements(items).size();

        Assertions.assertEquals( 6, actualItems);

        var firstInventoryItem = By.xpath("(//button[@class='btn_primary btn_inventory'])[1]");
        driver.findElement(firstInventoryItem).click();

        var lastInventoryItem = By.xpath("(//button[@class='btn_primary btn_inventory'])[6]");
        driver.findElement(lastInventoryItem).click();

        driver.navigate().to("https://www.saucedemo.com/v1/cart.html");


    }

    @Test
    public void firstItemInCart() {
        var firstItem = By.xpath("(//div[@class='inventory_item_name'])[1]");
        var t= driver.findElement(firstItem).getText();
        Assertions.assertEquals( "Sauce Labs Backpack", t);
    }
    @Test
    public void lastItemInCart() {
        var lasttItem = By.xpath("(//div[@class='inventory_item_name'])[2]");
        var t2= driver.findElement(lasttItem).getText();
        Assertions.assertEquals( "Test.allTheThings() T-Shirt (Red)", t2);
    }


    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
    }

    @AfterEach
    public void afterEach(){

        driver.quit();
    }

}
