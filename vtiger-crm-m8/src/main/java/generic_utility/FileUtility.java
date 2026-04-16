package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	public String getDataFromPropFile(String key) throws IOException {
//		step 1:> create a Java Rep. Object of the physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/cd.properties");

//		step 2:> by using load(), load all the keys
		Properties pObj = new Properties();
		pObj.load(fis);

//		step 3:> by using getProperty("key") get the value by passing "key"
		String value = pObj.getProperty(key);
		return value;
	}
	
	
	public String getDataFromExcelFile(String sheetName, int rowIndex, int cellIndex) throws IOException {
		FileInputStream fis2 = new FileInputStream("./src/test/resources/testScriptData.xlsx");

		Workbook wb = WorkbookFactory.create(fis2);

		Sheet sh = wb.getSheet(sheetName);

		Row row = sh.getRow(rowIndex);

		Cell cell = row.getCell(cellIndex);

		String value = cell.getStringCellValue();

		wb.close();
		
		return value;
	}

	public void getDataFromJsonFile() {

	}
}
