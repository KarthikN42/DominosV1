package com.domi.utilities;

public interface Constants {

    String EXCEL_PATH = "C:\\Users\\Spotcheck\\eclipse-workspace\\Dominos\\src\\test\\java\\com\\domi\\testData\\TestData.xlsx";
    String APP_SHEET_NAME = "Sheet1";
    String First_Cart_Value = ExcelHandling.getCellValue(EXCEL_PATH, APP_SHEET_NAME, 1, 1);
    String Second_Cart_Value= ExcelHandling.getCellValue(EXCEL_PATH, APP_SHEET_NAME, 2, 1);
    String Third_cart_value = ExcelHandling.getCellValue(EXCEL_PATH, APP_SHEET_NAME, 3, 1);
    
    
    }