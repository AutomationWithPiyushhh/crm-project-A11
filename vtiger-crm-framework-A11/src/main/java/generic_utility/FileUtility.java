package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	public String getDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\git\\A11-crm-framework\\vtiger-crm-framework-A11\\src\\test\\resources\\commondata.properties");

		Properties pObj = new Properties();
		pObj.load(fis);

		String value = pObj.getProperty(key);

		return value;
	}

	public String getStringDataFromExcelFile(String sheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis2 = new FileInputStream(
				"C:\\Users\\User\\git\\A11-crm-framework\\vtiger-crm-framework-A11\\src\\test\\resources\\testScrptData.xlsx");

		Workbook wb = WorkbookFactory.create(fis2);

		Sheet sh = wb.getSheet(sheetName);

		String value = sh.getRow(rowNum).getCell(cellNum).getStringCellValue();

		return value;
	}

	
	
	
	public int getNumericDataFromExcelFile(String sheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis2 = new FileInputStream(
				"C:\\Users\\User\\git\\A11-crm-framework\\vtiger-crm-framework-A11\\src\\test\\resources\\testScrptData.xlsx");

		Workbook wb = WorkbookFactory.create(fis2);

		Sheet sh = wb.getSheet(sheetName);

		int value = (int) sh.getRow(rowNum).getCell(cellNum).getNumericCellValue();

		return value;
	}

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileUtility fUtil = new FileUtility();
		int value1 = fUtil.getNumericDataFromExcelFile("Org", 1, 1); 
		System.out.println(value1);
	}
}
