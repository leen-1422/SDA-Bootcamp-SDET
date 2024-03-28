package pages.lambdtest;

import engine.ActionsBot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Pages;

public class Login extends Pages {

    public Login(WebDriver driver, ActionsBot bot) {
        super(driver,bot);
    }

    private final String url = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";
    private final By firstName = By.id("input-firstname");
    private final By lastName = By.id("input-lastname");
    private final By email = By.id("input-email");
    private final By telephone = By.id("input-telephone");
    private final By password = By.id("input-password");
    private final By confirmPassword = By.id("input-confirm");
    private final By privacyPolicy = By.xpath("//label[@for='input-agree']");

    private final By registerButton = By.xpath("//input[@type='submit']");




    @Step
    public Login toGo(){
        bot.navigate(url);
        return this;
    }



    @Step
    public Inventory login(String userFirstName,
                           String userLastName,
                           String userEmail,
                           String userPhone ,
                           String userPass,
                           String userConfirmPass){

        bot.type(firstName, userFirstName);
        bot.type(lastName, userLastName);
        bot.type(email,userEmail);
        bot.type(telephone,userPhone);
        bot.type(password,userPass);
        bot.type(confirmPassword,userConfirmPass);
        bot.click(privacyPolicy);
        bot.click(registerButton);

        return new Inventory(driver,bot);
    }


}
