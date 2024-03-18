package tests.Assignments.Assignment2;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.testng.Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Q2 extends Tests {


    /*
    Go to https://testpages.eviltester.com/styled/apps/notes/simplenotes.html
    Add 10 notes using data provider with excel
    Run it with 3 different browsers using XML file
    Run it parallel with 3 threads
     */


    @DataProvider(name = "excelData")
    public Object[][] excelDataProvider() throws IOException {
        Object[][] arrObj = getExcelData("C:\\Users\\Leen\\OneDrive\\Desktop\\اخر واجبات\\Data Modeling Exercise\\Departments.xlsx","Departments");
        return arrObj;
    }

    public String[][] getExcelData(String fileName, String sheetName)  {
        String[][] data = null;
        try {

            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow row = sheet.getRow(0);
            int noOfRows = sheet.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();
            Cell cell;
            data = new String[noOfRows - 1][noOfCols];

            for (int i = 1; i < noOfRows; i++) {
                for (int j = 0; j < noOfCols; j++) {
                    row = sheet.getRow(i);
                    cell = row.getCell(j);
                    data[i - 1][j] = cell.getStringCellValue();
                }
            }
        } catch (Exception e) {
            System.out.println("The exception is: " + e.getMessage());
        }
        return data;
    }

    @Test( dataProvider = "excelData")
    @Parameters({"search-query"})
    public void searchFunctionWithDataProvider(String keyWord1, String keyWord2) {
        driver.navigate().to("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");
        By title = By.id("note-title-input");
        By note = By.id("note-details-input");
        driver.findElement(title).sendKeys(keyWord1);
        driver.findElement(note).sendKeys(keyWord2);
        driver.findElement(By.id("add-note")).click();

    }
}
