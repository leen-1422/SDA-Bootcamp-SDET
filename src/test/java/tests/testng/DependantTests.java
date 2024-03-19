package tests.testng;


import org.testng.annotations.Test;

public class DependantTests extends Tests{

    @Test
    public void facebookNavigation(){
        driver.navigate().to("https://www.facebook.com/");
    }
    @Test (dependsOnMethods = "facebookNavigation" )
    public void googleNavigation(){
        driver.navigate().to("https://www.google.com/");
    }
    @Test (dependsOnMethods = "googleNavigation" )
    public void amazonNavigation(){
        driver.navigate().to("https://www.amazon.com/");
    }
}
