package com.util;


import com.google.common.io.Files;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;

public class SeleniumHelper {

    /*This is method for the SpreadSheet reader
     * Use this method to read the spreadsheet*/
    public static Object[][] readXL(File path) throws IOException {

        FileInputStream file = null;
        XSSFWorkbook book = null;
        XSSFSheet sheet = null;
        Object[][] data = null;

        try {
            file = new FileInputStream(path);
            book = new XSSFWorkbook(file);
            sheet = book.getSheetAt(0);

            /*we need last row number
             * and last cell number from that row*/

            int rowNum = sheet.getLastRowNum(); //will get the last row number from the sheets
            int cellNum = sheet.getRow(0).getLastCellNum(); // this will get the last cell number from the row
            data = new Object[rowNum][cellNum];

            /*we need a loop for loop thru the sheets*/

            for (int i = 1; i < rowNum; i++) {
                // first loop will get row
                for (int j = 0; j < cellNum; j++) {
                    //this loop will get the cell from the row
                    XSSFCell cell = sheet.getRow(i).getCell(j); // this will store the data from the sheets in cell

                    switch (cell.getCellType()) {
                        case XSSFCell.CELL_TYPE_NUMERIC:

                            data[i - 1][j] = cell.getNumericCellValue();
                        case XSSFCell.CELL_TYPE_STRING:
                            data[i - 1][j] = cell.getStringCellValue();

                        default:
                            break;
                    }


                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            file.close();
            book.close();

        }
        return data;

    }

    /*Use this method to click on multiple elements with one method*/

    public void click(List<WebElement> elements) {
        for (WebElement element : elements) {
            element.click();
        }
    }

    public void click(List<WebElement> elements, int index) {
        elements.get(index).click();
    }

    public void click(WebDriver driver, List<WebElement> elements, String givenText) {
        for (WebElement element : elements) {
            if (element.getText().equals(givenText)) {
                continue;
            } else {
                element.click();
                driver.navigate().back();
                driver.navigate().refresh();

            }
        }
    }

    public void verifyTheItem(List<WebElement> elements, String givenText) {
        for (WebElement element : elements) {
            String webText = element.getText();

            if (webText.equals(givenText)) {
                System.out.println(webText + " " + "<<< is verifed");
            } else {
                System.out.println(webText + " " + "<<<can not verify");
            }

        }
    }

    /*this method will generate date and time for the screenshot taker method
     * Before you use this method please test it*/

    public static String generateDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    /*This method is using the generateDate() << to get the date and time
    * So the takeScreenShot()<< use it for taking screenshot with different name*/
    public static void takeScreenShot(WebDriver driver) throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        Files.copy(SrcFile, new File("ScreenShots/pic_" + generateDate() + ".png"));
    }

    /*This method will help to read the property file*/
    public static Properties readProperties(String path) throws IOException {
        FileInputStream file = new FileInputStream(new File(path));
        Properties properties = new Properties();
        properties.load(file);
        return properties;
    }

    /*very power-full method to do click actions*/
    public static WebElement waitForElement(WebElement element, WebDriver driver, int second) {
        WebDriverWait wait = new WebDriverWait(driver, second);
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
        return element1;
    }

    /*Use this method to pass text in the parameter*/
    public static void type(WebElement element, String givenText) {
        element.sendKeys(givenText);
    }
}

