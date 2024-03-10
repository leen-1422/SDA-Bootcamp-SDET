package testPackage;







//Finally print on console this message "Hello Bootcamp How are you today" assertion these message.

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlarmTest extends TestBase{
    @Test
    public void simpleAlert(){
        driver.navigate().to("http://demo.automationtesting.in/Alerts.html");
        By AlertWithOkButton = By.xpath("//a[contains(@href,'#OKTab')]");
        By displayAlertBox = By.xpath("//button[contains(@class,'btn-danger')]");

        driver.findElement(AlertWithOkButton).click();
        driver.findElement(displayAlertBox).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();

    }
    @Test
    public void cnofirmAlert(){
        driver.navigate().to("http://demo.automationtesting.in/Alerts.html");
        By AlertWithOkButton = By.xpath("//a[contains(@href,'#CancelTab')]");
        By displayAlertBox = By.xpath("//button[contains(@class,'btn-primary')]");

        driver.findElement(AlertWithOkButton).click();
        driver.findElement(displayAlertBox).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
    }

    @Test
    public void promptAlert(){
        driver.navigate().to("http://demo.automationtesting.in/Alerts.html");
        By AlertWithOkButton = By.xpath("//a[contains(@href,'#Textbox')]");
        By displayAlertBox = By.xpath("//button[contains(@class,'btn-info')]");

        driver.findElement(AlertWithOkButton).click();
        driver.findElement(displayAlertBox).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("Bootcamp");
        alert.accept();

        By txt= By.id("demo1");
        Assertions.assertEquals("Hello Bootcamp How are you today", driver.findElement(txt).getText());

    }


}
