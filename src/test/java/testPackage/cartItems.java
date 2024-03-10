package testPackage;


//Task 2:

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//     * navigate to this url https://www.saucedemo.com/v1/inventory.html
//        * add the first item you find to your cart
//     * open your cart*
//        * assert that the item name is correct inside the cart
//        */
public class cartItems {

    WebDriver driver;

    @Test
    public void firstItem(){
        By firstItemInCart = By.xpath("(//button[@class='btn_primary btn_inventory'])[1]");
        driver.findElement(firstItemInCart).click();

        driver.navigate().to("https://www.saucedemo.com/v1/cart.html");

        var cartItem = By.xpath("//div[@class='inventory_item_name']");
        var actualResult2 = driver.findElement(cartItem).getText();
        Assertions.assertEquals("Sauce Labs Backpack", actualResult2);
    }

    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");
    }

    @AfterEach
    public void afterEach(){

        driver.quit();
    }
}
