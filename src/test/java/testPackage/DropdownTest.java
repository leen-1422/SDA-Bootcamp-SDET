package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

//https://demoqa.com/select-menu
//Get all the options of the dropdown
//Options size
//Print all test
//Verify the dropdown has option "Black"
//Print FirstSelectedOptionTest
//Select option "Yellow"

public class DropdownTest extends TestBase{

    @Test
    public void dropdownOptions(){
        driver.navigate().to("https://demoqa.com/select-menu");

        By selectElement = By.id("oldSelectMenu");
        Select select = new Select(driver.findElement(selectElement));
        List<WebElement> allOptions = select.getOptions();
        System.out.println(allOptions.size());


        List<String> optionsText = select.getOptions().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        System.out.println(optionsText);

        boolean hasBlackOption = optionsText.contains("Black");
        Assertions.assertTrue(hasBlackOption);

        String FirstSelectedOptionTest = select.getFirstSelectedOption().getText();
        System.out.println(FirstSelectedOptionTest);

        select.selectByVisibleText("Yellow");
        String actText = select.getAllSelectedOptions().getFirst().getText();
        Assertions.assertEquals("Yellow", actText);

    }

}
