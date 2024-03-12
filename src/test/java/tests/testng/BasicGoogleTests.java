package tests.testng;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class BasicGoogleTests extends Tests{
    @Test
    public void search(){

        driver.navigate().to("https://www.google.com/");
        By search = By.id("APjFqb");
        driver.findElement(search).sendKeys("Selenium" + Keys.RETURN);

        By result = By.id("result-stats");
        assert !"".equals(driver.findElement(result).getText());

//        bot.navigate("https://www.google.com/");
//        By search = By.id("APjFqb");
//        bot.type(search, "Selenium" + Keys.RETURN);
//        By result = By.id("result-stats");
//



    }


}
