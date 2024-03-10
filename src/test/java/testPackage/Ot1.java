package testPackage;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


//        assert that the item name is correct inside the cart

public class Ot1 {
    WebDriver driver;

    @Test
    public void checkNameOfFirstElement() {

        var firstInventoryItem = By.xpath("(//button[@class='btn_primary btn_inventory'])[2]");
        driver.findElement(firstInventoryItem).click();

        // "//a[@href='./cart.html']"
        // shopping_cart_link fa-layers fa-fw

        var cart = By.xpath("//a[@href='./cart.html']");
        driver.findElement(cart).click();


        var cartItem = By.xpath("(//div[@class='inventory_item_name'])[1]");
        var actualResult2 = driver.findElement(cartItem).getText();
        Assertions.assertEquals("Sauce Labs Backpack", actualResult2);

    }

    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }

}
