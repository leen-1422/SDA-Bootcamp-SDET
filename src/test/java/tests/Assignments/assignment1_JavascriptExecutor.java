package tests.Assignments;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.bidi.browsingcontext.BrowsingContext;
import org.openqa.selenium.interactions.SourceType;
import tests.junit.TestBase;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.interactions.Actions;


import java.io.*;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.Set;


// assignment-1 ✅
// assignment-2 ✅
// assignment-3 ✅
// assignment-4 ✅
// assignment-5 ✅
// assignment-6 ✅
// assignment-7 ✅


public class assignment1_JavascriptExecutor extends TestBase {

    @Test
    public void doubleClickElementCheck() {
        driver.navigate().to("https://api.jquery.com/dblclick/");

        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement dblClickElement = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(dblClickElement);

        WebElement blueColouredButton = driver.findElement(By.cssSelector("body>div"));

        js.executeScript("arguments[0].scrollIntoView();", blueColouredButton);

        String beforeClickColor = blueColouredButton.getCssValue("background-color");
        System.out.println("color = " + beforeClickColor);
        actions.doubleClick(blueColouredButton).perform();

        String color = blueColouredButton.getCssValue("background-color");
        System.out.println("color = " + color);
        Assertions.assertNotEquals(beforeClickColor, color);
        driver.switchTo().defaultContent();

        js.executeScript("window.scrollTo(0,0)");
        driver.findElement(By.name("s")).sendKeys("Thanks to JavascriptExecutor");
        WebElement jQueryBook = driver.findElement(By.xpath("//a[contains(@href,'jquery-in-action-third-edition')]"));
        js.executeScript("arguments[0].scrollIntoView();", jQueryBook);
        jQueryBook.click();
    }

    @Test
    public void titleTest(){
        driver.navigate().to("https://the-internet.herokuapp.com/windows");

        var header = driver.findElement(By.tagName("h3")).getText();
        Assertions.assertEquals("Opening a new window", header);
        var title = driver.getTitle();
        Assertions.assertEquals("The Internet", title);
        var button = driver.findElement(By.xpath("//a[contains(@href,'new')]"));
        var originalWindowHandle = driver.getWindowHandle();

        button.click();

        Set<String > handles = driver.getWindowHandles();
        handles.remove(originalWindowHandle);
        String newWindowHandle = (String) handles.toArray()[0];
        driver.switchTo().window(newWindowHandle);

        driver.getTitle();
        var newHeader = driver.findElement(By.tagName("h3")).getText();
        Assertions.assertEquals("New Window", newHeader);

        driver.switchTo().window(originalWindowHandle);
        var entitle = driver.getTitle();
        Assertions.assertEquals("The Internet", entitle);

    }


    @Test
    public void dragAndDrop(){
        driver.navigate().to("http://demo.guru99.com/test/drag_drop.html");
        performDragAndDrop(By.id("credit2"), By.id("bank"));
        performDragAndDrop(By.id("credit1"), By.id("loan"));
        performDragAndDrop(By.xpath("(//li[@id='fourth'])[1]"), By.id("amt7"));
        performDragAndDrop(By.xpath("(//li[@id='fourth'])[2]"), By.id("amt8"));

    }
    private void performDragAndDrop(By draggableLocator, By droppableLocator) {
        Actions actions = new Actions(driver);
        WebElement draggable = driver.findElement(draggableLocator);
        WebElement droppable = driver.findElement(droppableLocator);
        actions.dragAndDrop(draggable, droppable).perform();
    }

    @Test
    public void keysActionsTest(){
        driver.navigate().to("https://www.google.com/");
        var searchInput = driver.findElement(By.id("APjFqb"));
        searchInput.sendKeys(Keys.SHIFT + "s" + Keys.SHIFT + "croll" + Keys.SPACE + Keys.SHIFT + "m" + Keys.SHIFT + "ethods" );
    }


    @Test
    public void cookiesTest(){
        driver.navigate().to("http://facebook.com");
        var cookies = driver.manage().getCookies();
        cookies.forEach(System.out::println);

        driver.manage().addCookie(new Cookie("Name", "Leen"));
        driver.manage().addCookie(new Cookie("lastName", "Alsultan"));

        driver.manage().deleteCookieNamed("lastName");

        driver.manage().deleteAllCookies();

    }

    @Test
    public void excelFile() throws IOException {
        String filePath = "C:\\Users\\Leen\\OneDrive\\Desktop\\اخر واجبات\\Data Modeling Exercise\\Departments.xlsx";

        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet("Departments");

        Row firstRow = sheet.getRow(0);
        Cell populationCell = firstRow.createCell(2);
        populationCell.setCellValue("POPULATION");

        sheet.getRow(1).createCell(2).setCellValue("10");
        sheet.getRow(2).createCell(2).setCellValue("20");
        sheet.getRow(3).createCell(2).setCellValue("30");

        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        workbook.write(fileOutputStream);


    }

    @Test
    public void takeScreenShot() throws IOException {
        driver.navigate().to("https://the-internet.herokuapp.com/windows");

        File screenshot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File ElementScreenshot= driver.findElement(By.tagName("h3")).getScreenshotAs(OutputType.FILE);

        File files = new File("target/screenshot"+System.currentTimeMillis()+".png");
        File ElementFiles = new File("target/ElementScreenshot"+System.currentTimeMillis()+".png");
        Files.copy(screenshot.toPath(), files.toPath());
        Files.copy(ElementScreenshot.toPath(), ElementFiles.toPath());


    }

}
