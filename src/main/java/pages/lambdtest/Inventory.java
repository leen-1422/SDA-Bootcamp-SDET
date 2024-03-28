package pages.lambdtest;

import engine.ActionsBot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Pages;

public class Inventory extends Pages {
    private final String url = "https://ecommerce-playground.lambdatest.io/index.php?route=account/success";
    public Inventory(WebDriver driver, ActionsBot bot){
        super(driver,bot);
    }
}
