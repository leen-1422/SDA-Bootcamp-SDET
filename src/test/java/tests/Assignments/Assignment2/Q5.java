package tests.Assignments.Assignment2;

//Go to URL: http://crossbrowsertesting.github.io/
//Click to To-Do App
//Checking Box to do-4 and Checking Box to do-5
//If both clicks worked, then the following List should be have length 2.
//Assert that this is correct
//Assert that the to do we added is present in the list
//Archiving old todos
//If our archive link worked, then the following list should have length 4.
//Assert that this is true as well
//Doing Cross Browser Testing.

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.testng.Tests;

public class Q5 extends Tests {
  @Parameters({"search-query"})
    @Test
    public void TodoApp(){
   driver.navigate().to("http://crossbrowsertesting.github.io/");
   By todoLink = By.xpath("//a[@href='todo-app.html']");
   driver.findElement(todoLink).click();

   By check4= By.name("todo-4");
   By check5= By.name("todo-5") ;
   By remainingMsg= By.className("ng-binding");

   driver.findElement(check4).click();
   driver.findElement(check5).click();

   Assert.assertEquals(driver.findElement(remainingMsg).getText(),"3 of 5 remaining");

   By todoBox = By.id("todotext");

   driver.findElement(todoBox).sendKeys("walk" + Keys.RETURN);

   Assert.assertTrue(driver.findElement(By.xpath("(//input[contains(@class,'ng-valid')])[6]")).isDisplayed());

    By archive= By.xpath("//a[@ng-click='todoList.archive()']");
    driver.findElement(archive).click();

    Assert.assertEquals(driver.findElement(remainingMsg).getText(),"4 of 4 remaining");


    }

}
