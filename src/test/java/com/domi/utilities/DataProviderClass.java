package com.domi.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;

public class DataProviderClass implements Constants {


    public static Object[][] readExcelDataProvider(String excelPath,String sheetName){
        ExcelHandling ex=new ExcelHandling();
        XSSFSheet sheet = ex.getExcelSheet(excelPath,sheetName);
        int rowCount = sheet.getLastRowNum();
        int column = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount][column];
        for (int i = 1; i <= rowCount; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < column; j++) {
                XSSFCell cell = row.getCell(j);
                DataFormatter formatter = new DataFormatter();
                String val = formatter.formatCellValue(cell);
                data[i - 1][j] = val;
            }
        }

        return data;
    }
    
    public static Object[][] readExcelDataProviderCustomRange(String excelPath, String sheetName, int startRow, int rowCount, int colCount){
        ExcelHandling ex=new ExcelHandling();
        XSSFSheet sheet = ex.getExcelSheet(excelPath,sheetName);
        Object[][] data = new Object[rowCount][colCount];
        for (int i = startRow; i <= rowCount+(startRow-1); i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                XSSFCell cell = row.getCell(j);
                DataFormatter formatter = new DataFormatter();
                String val = formatter.formatCellValue(cell);
                data[i - startRow][j] = val;
            }
        }
        return data;
    }
    
    @DataProvider(name="appLogin")
    public Object[][] professionalSignUpDataProvider(){	
        return DataProviderClass.readExcelDataProvider(EXCEL_PATH,APP_SHEET_NAME);
    }


}
