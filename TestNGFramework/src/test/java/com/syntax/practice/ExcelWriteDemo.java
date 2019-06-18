package com.syntax.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWriteDemo {
	
	@Test
	public void writeExcel() throws Exception {
		File src= new File("C:\\Users\\Samsung\\Desktop\\test3.xlsx");
		FileInputStream fis= new FileInputStream(src);
		XSSFWorkbook wb1= new XSSFWorkbook(fis);
		XSSFSheet sheet= wb1.getSheet("emp");
		//write some values
//		sheet.getRow(0).createCell(4).setCellValue("Result");
//		sheet.getRow(1).createCell(4).setCellValue("Pass");
		//sheet.getRow(1).getCell(4).setCellValue("Fail");
		sheet.createRow(11).createCell(0).setCellValue("Kevinn");
		
		//write to excel
		FileOutputStream fos= new FileOutputStream(src);
		wb1.write(fos);
		
		fos.close();
		wb1.close();
		fis.close();
		
	}

}
