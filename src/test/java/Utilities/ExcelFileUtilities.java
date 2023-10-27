package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtilities {

	public String getDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fileIn= new FileInputStream(IConstantUtilities.excelFilePath);
		Workbook book = WorkbookFactory.create(fileIn);
		Sheet sheet = book.getSheet(sheetName);
		return sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
	}
}
