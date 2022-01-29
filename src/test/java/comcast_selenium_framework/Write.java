package comcast_selenium_framework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Write {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fi =new FileInputStream("./excel/testdata.xlsx");
		Workbook book = WorkbookFactory.create(fi);
		Sheet sh = book.getSheet("Sheet1");
		Row ro = sh.getRow(1);
		Cell cell = ro.createCell(4);
		cell.setCellValue("PASS");
		
		FileOutputStream fo= new FileOutputStream("./excel/testdata.xlsx");
		book.write(fo);
		book.close();
		
	}

}
