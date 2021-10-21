package com.dataProvider;

import com.util.SeleniumHelper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExeclSheetDataProvider {


    @DataProvider(name = "loginData")
    public Object[][] readXL() throws IOException {

        FileInputStream file = null;
        XSSFWorkbook book = null;
        XSSFSheet sheet = null;
        Object[][] data = null;

        try {
            file = new FileInputStream(new File("filePath"));
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
	

}
