package selenium.utilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	Workbook wb;
	
	public ExcelDataProvider() {
		
		File file = new File("./testdata/data.xlsx");
		try {
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage()+":Unable to ead excel file");
		}
		
		
	}
	
	public String getStringValue(int index, int rowNumber, int columnNumber) {
		return wb.getSheetAt(index).getRow(rowNumber).getCell(columnNumber).getStringCellValue();
	}
	
	public String getStringValue(String sheetName, int rowNumber, int columnNumber) {
		return wb.getSheet(sheetName).getRow(rowNumber).getCell(columnNumber).getStringCellValue();
	}
	
	public double getNumericValue(String sheetName, int rowNumber, int columnNumber) {
		return wb.getSheet(sheetName).getRow(rowNumber).getCell(columnNumber).getNumericCellValue();
	}

	
	
	
}
