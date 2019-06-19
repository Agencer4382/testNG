package com.syntax.practice;

import org.testng.annotations.Test;

import com.syntax.utils.Constants;
import com.syntax.utils.ExcelUtility;

public class ExcelFuntionsTest {

	@Test
	public void excelTest() {
		
		ExcelUtility obj=new ExcelUtility();
		obj.openExcel(Constants.XL_FILEPATH, "Loc");
		//String value =obj.getCellData(1, 2);
		//System.out.println(value);
	
		int row=obj.getRowNum();
		int cell=obj.getColNum(0);
		
		Object[][] data = new Object[row][cell];
		
		for(int i=1; i<row; i++) {
			cell=obj.getColNum(i);
			for(int y=0; y<cell; y++) {
				
				String value=obj.getCellData(i, y);
				data[i][y]=value;
				
			}
			
		}
		System.out.println(data.length);
	}
}