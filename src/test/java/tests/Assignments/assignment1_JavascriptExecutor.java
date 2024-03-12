package tests.Assignments;

import org.junit.jupiter.api.Test;
import tests.junit.TestBase;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


//Go to URL: https://api.jquery.com/dblclick/
//Double click on the blue square at the bottom of the page and then write the changed color.
//Go top of the page and sendKeys "Thanks to JavascriptExecutor"
//Go to the bottom of the page and click the book, name"jQuery in Action"


public class assignment1_JavascriptExecutor extends TestBase {

    @Test
    public void doubleClickElementCheck() {

        driver.navigate().to("https://api.jquery.com/dblclick/");

        // It creates an Actions object to perform advanced user interactions, such as double-clicking.
        //  It creates a JavascriptExecutor object to execute JavaScript code.
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Double-click on the blue square at the bottom of the page and then write the changed color.

        // It locates an <iframe> element on the page using the By.tagName locator strategy and assigns it to the dblClickElement variable.
        WebElement dblClickElement = driver.findElement(By.tagName("iframe"));
        // It switches the driver's context to the identified <iframe> element.
        // When a web page contains an <iframe>, it represents a separate HTML document embedded within the main HTML document.
        driver.switchTo().frame(dblClickElement);

        // within the iframe's content using the CSS selector body>div and assigns it to the blueColouredButton variable.
        WebElement blueColouredButton = driver.findElement(By.cssSelector("body>div"));


        // It scrolls the page to bring the blueColouredButton element into view using JavaScript.
        js.executeScript("arguments[0].scrollIntoView();", blueColouredButton);

        // It scrolls the page to bring the blueColouredButton element into view using scrollToElement().
        // actions.scrollToElement(blueColouredButton);


        // It retrieves the value of the background-color CSS property of the blueColouredButton element and assigns it to the beforeClickColor variable.
        String beforeClickColor = blueColouredButton.getCssValue("background-color");
        System.out.println("color = " + beforeClickColor);

        actions.doubleClick(blueColouredButton).perform();


        //  It retrieves the updated value of the background-color CSS property of the blueColouredButton element after the double-click action and assigns it to the color variable.
        String color = blueColouredButton.getCssValue("background-color");
        System.out.println("color = " + color);

        Assertions.assertNotEquals(beforeClickColor, color);

        driver.switchTo().defaultContent();


        //Go top of the page and sendKeys "Thanks to JavascriptExecutor"
        js.executeScript("window.scrollTo(0,0)");
        driver.findElement(By.name("s")).sendKeys("Thanks to JavascriptExecutor");

        //Go to the bottom of the page and click the book, name"jQuery in Action"
        WebElement jQueryBook = driver.findElement(By.xpath("//a[contains(@href,'jquery-in-action-third-edition')]"));
        js.executeScript("arguments[0].scrollIntoView();", jQueryBook);
        jQueryBook.click();



    }
}
