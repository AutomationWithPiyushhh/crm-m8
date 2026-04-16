package ddt_extra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/testScriptData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
								
		String value1 = wb.getSheet("org").getRow(1).getCell(0).getStringCellValue();
		String value2 = wb.getSheet("org").getRow(1).getCell(2).getStringCellValue();
		String value3 = wb.getSheet("org").getRow(1).getCell(5).getStringCellValue();
		
//		String value1 = wb.getSheet("org").getRow(1).getCell(0).getStringCellValue();
//		long value2 = (long)wb.getSheet("org").getRow(1).getCell(2).getNumericCellValue();
//		boolean value3 = wb.getSheet("org").getRow(1).getCell(5).getBooleanCellValue();
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		
		wb.close();
	}
}
