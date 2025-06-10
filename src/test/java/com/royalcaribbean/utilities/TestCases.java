package com.royalcaribbean.utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



//Class to write data into excel for output
public class TestCases {
	
	//Method to write data into excel using Apache POI
	 public static void writeTestCase(List<String> testCases) throws IOException
	 {
		 XSSFWorkbook workbook = new XSSFWorkbook();
		 XSSFSheet sheet = workbook.createSheet("Sheet1");
		 for(int i=0;i<testCases.size();i++)
		 {
			 XSSFRow row = sheet.createRow(i);
			 XSSFCell cell = row.createCell(0);
			 cell.setCellValue(testCases.get(i));
		 }
		// cell.setCellValue(testCase);
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"//src//test//resources//testcases.xlsx");	
		workbook.write(file);
		workbook.close();
		 
		 
	 }

}
