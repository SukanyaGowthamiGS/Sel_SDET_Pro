package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelUtility {
	/**
	 *  read the data from excel base don below arguments 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return Data
	 * @throws Throwable
	 */
	/**
	 *  its used read the data from excel base don below arguments 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return Data
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheet , int rownum, int celnum) throws Throwable {
		FileInputStream fis  = new FileInputStream("./data/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row row = sh.getRow(rownum);
		String data = row.getCell(celnum).getStringCellValue();
		wb.close();
		return data;
	}
	/**
	 * This method used to get the last used row number on specified Sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis  = new FileInputStream("./data/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
    }

	
	/**
	 * This 
	 * @param sheetName
	 */
	
	public void setDataExcel(String sheetName , int rowNum, int celNum ,String data) throws Throwable {
		FileInputStream fis  = new FileInputStream("./data/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
	    Cell cell = row.createCell(celNum);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./data/testdata.xlsx");
		wb.write(fos);
		wb.close();
		}
}


	