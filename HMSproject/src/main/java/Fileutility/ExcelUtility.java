package Fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public static final String path = "./data/HMS Test Data.xlsx";
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(fis);
		String data = book.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		book.close();

		return data;
	}
    public void setDataIntoExcel(String sheetName, int rowNum, int cellNum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(fis);
		book.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);

		FileOutputStream fos = new FileOutputStream(path);
		book.write(fos);
		book.close();

	}

}
