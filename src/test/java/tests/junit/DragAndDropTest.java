package tests.junit;

//navigate to https://www.selenium.dev/selenium/web/droppableItems.html
//drag the draggable, onto the droppable
//check that the text now shows "Dropped!"

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

public class DragAndDropTest extends TestBase{
    @Test
    public void dragAndDropAction(){
        driver.navigate().to("https://www.selenium.dev/selenium/web/droppableItems.html");
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        new Actions(driver)
                .dragAndDrop(draggable, droppable)
                .perform();

        var msg= driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
        Assertions.assertEquals("Dropped!", msg);
    }
    @Test
    public void range() {
        driver.navigate().to("https://rangeslider.js.org/");

        WebElement iframe = driver.findElement(By.id("js-rangeslider-0"));

        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(iframe);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 100, 0)
                .perform();

    }

    /**
     * Breakout task: 15 minutes
     * Navigate to <a href="https://kitchen.applitools.com/ingredients/cookie">Cookies</a>
     * print the total number of cookies
     * add a new "fruit=apple" cookie
     * edit the "protein" cookie to have the value "meat"
     * delete the "veggie" cookie
     * print all cookies
     * delete all cookies
     */

    @Test
    public void websiteCookies(){
        driver.navigate().to("https://kitchen.applitools.com/ingredients/cookie");
        var cookies = driver.manage().getCookies();
        System.out.println(cookies.size());

        // :: -> method reference
        cookies.forEach(System.out::println);

        // add cookies
        driver.manage().addCookie(new Cookie("fruit", "apple"));
        // edit cookies by overriding already existing one
        driver.manage().addCookie(new Cookie("protein", "meat"));
        // delete cookie
        driver.manage().deleteCookieNamed("vegetable");

        var updatedC = driver.manage().getCookies();
        updatedC.forEach(System.out::println);

        driver.manage().deleteAllCookies();

        System.out.println(driver.manage().getCookies().size());

    }
}
