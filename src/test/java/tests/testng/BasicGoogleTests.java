package tests.testng;

import engine.CutomeListner;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

@Listeners(CutomeListner.class)
public class BasicGoogleTests extends Tests{
    @Parameters({"search-query"})

    @Test(groups = {"sanityCheck", "guiTests"})

    public void search(@Optional("Selenium WebDriver")String searchQuery){

        driver.navigate().to("https://www.google.com/");
        By search = By.id("APjFqb");
        driver.findElement(search).sendKeys("Selenium" + Keys.RETURN);



        // wait.until(d -> revealed.isDisplayed());
        By result = By.id("result-stats");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        assert !"".equals(driver.findElement(result).getText());

//        bot.navigate("https://www.google.com/");
//        By search = By.id("APjFqb");
//        bot.type(search, "Selenium" + Keys.RETURN);
//        By result = By.id("result-stats");
//



    }


}
