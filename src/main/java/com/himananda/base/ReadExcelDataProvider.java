package com.himananda.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;

import com.sun.media.sound.InvalidFormatException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcelDataProvider {

	final Logger log = Logger.getLogger(ReadExcelDataProvider.class);

	@DataProvider(name = "LoginCredentials")
	public Object[][] loginData() {
		log.info("Entered DataProvider ...");
		Object[][] arrayObject = getExcelData(
				"C:\\Users\\Hreddy\\eclipse-workspace\\sample-framework\\src\\main\\resources\\testData\\Credentials.xls.xlsx",
				"Sheet1");
		return arrayObject;
	}

	
	/**
	 * @param File
	 *            Name
	 * @param Sheet
	 *            Name
	 * @return
	 */
	public String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			log.info("Creating file ..");
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();

			arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];

			log.info("Extracting excel ... data ");
			for (int i = 1; i < totalNoOfRows; i++) {

				for (int j = 0; j < totalNoOfCols; j++) {
					arrayExcelData[i - 1][j] = sh.getCell(j, i).getContents();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}

}