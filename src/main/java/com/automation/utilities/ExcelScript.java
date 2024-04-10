package com.automation.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelScript {
    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;

    public static int getRowCount(String filePath, String sheetName) throws IOException {
        fi = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        int rowCount = ws.getLastRowNum();
        wb.close();
        fi.close();
        return rowCount;
    }

    public static int getCellCount(String filePath, String sheetName, int rowNum) throws IOException {
        fi = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rowNum);
        int cellCount = row.getLastCellNum();
        wb.close();
        fi.close();
        return cellCount;
    }

    public static String getCellData(String filePath, String sheetName, int rowNum, int colnum) throws IOException {
        fi = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rowNum);
        cell = row.getCell(colnum);
        String data;
        try {
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);
        } catch (Exception e) {
            data = "";
        }
        wb.close();
        fi.close();
        return data;
    }

    public static void setCellData(String filePath, String sheetName, int rowNum, int colnum, String data) throws IOException {
        fi = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rowNum);
        cell = row.createCell(colnum);
        cell.setCellValue(data);
        fo = new FileOutputStream(filePath);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();
    }
}