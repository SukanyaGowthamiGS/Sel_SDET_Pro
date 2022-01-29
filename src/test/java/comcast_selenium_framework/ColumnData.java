package comcast_selenium_framework;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ColumnData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fi =new FileInputStream("./excel/testdata.xlsx");
		Workbook book = WorkbookFactory.create(fi);
		Sheet sh = book.getSheet("Sheet1");
		int count=sh.getLastRowNum();
		for (int i = 1; i < count; i++) {
			Row ro = sh.getRow(i);
			String firstColData = ro.getCell(0).getStringCellValue();
			String secondColData = ro.getCell(1).getStringCellValue();
			System.out.println(firstColData+"\t"+secondColData);
			
		}
	}
}
