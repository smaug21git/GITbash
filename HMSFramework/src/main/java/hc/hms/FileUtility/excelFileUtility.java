package hc.hms.FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelFileUtility {

	/**
	 * This method is used to read data from Excel file
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	public String toReadDataFromExcel(String sheetname, int row, int cell) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\HMS.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
		return value;
	}
	
	/**
	 * This method is used to get last row number in the excel sheet
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetname) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int value = wb.getSheet(sheetname).getLastRowNum();
		return value;
	}
	
	/**
	 * This method is used to return value to new cell
	 * @param args
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @param value 
	 * @throws Throwable
	 */
	public static void main(String[] args, String sheetname, int row, int cell, Date value) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 wb.getSheet(sheetname).getRow(row).createCell(cell).setCellValue(value);
		 FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		 wb.write(fos);
	}
}
