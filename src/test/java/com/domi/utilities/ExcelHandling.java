package com.domi.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelHandling {
    public static String getCellValue(String path, String sheetName, int row, int cell){
        String value = "";
        try {
            File file=new File(path);
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFCell cellValue = wb.getSheet(sheetName).getRow(row).getCell(cell);
            DataFormatter formatter=new DataFormatter();
            value=formatter.formatCellValue(cellValue);
            wb.close();
        } catch (NullPointerException e) {
            // Will ignore
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
        return value;
    }

    public XSSFSheet getExcelSheet(String filePath, String sheetName) {
        XSSFSheet sheet = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            sheet=workbook.getSheet(sheetName);
            workbook.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sheet;

    }
}

