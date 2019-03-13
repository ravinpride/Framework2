package com.learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	public ExcelDataProvider() {
		File src = new File(".\\TestData\\DataProvider.xlsx");

		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			System.out.println("Unable to read excel file because of " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Unable to read excel file because of " + e.getMessage());
		}

	}
	
	public String getStringData(int sheetindex, int rowindex, int cellnum) {
		return wb.getSheetAt(sheetindex).getRow(rowindex).getCell(cellnum).getStringCellValue();
	}
	
	public String getStringData(String sheetname, int rowindex, int cellnum) {
		return wb.getSheet(sheetname).getRow(rowindex).getCell(cellnum).getStringCellValue();
	}
	
	public double getNumericData(String sheetname, int rowindex, int cellnum) {
		return wb.getSheet(sheetname).getRow(rowindex).getCell(cellnum).getNumericCellValue();
	}
}
