package tests.testng;

import engine.ActionsBot;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


import java.time.Duration;

public abstract class Tests {
    protected WebDriver driver;
    protected Wait<WebDriver> wait;
    protected static Logger logger;

    protected ActionsBot bot;

    @BeforeClass
    public static void beforeClass(){
        Configurator.initialize(null, "src/main/resources/properties/log4j2.properties");
        logger = LogManager.getLogger(Tests.class.getName());
    }
@Parameters({ "target-browser" })

    @BeforeMethod
    public void beforeMethod(@Optional("chrome") String targetBrowser){
    logger.info("Opening "+targetBrowser+" Browser");
         logger.info("Opening Browser");
         switch (targetBrowser){
             case "chrome" -> driver = new ChromeDriver();
             case "edge" -> driver = new EdgeDriver();
             case "firefox" -> driver = new FirefoxDriver();
         }

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
         logger.info("Configuring 5 second explicit wait");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));


    }

    @AfterMethod
    public void afterMethod(){
        logger.info("Quitting Browser");
        driver.quit();
    }
    @AfterClass
    public void after(){

        driver.quit();
    }

}
