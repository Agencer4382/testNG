package com.syntax.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;
import com.syntax.utils.Constants;
import com.syntax.utils.ExcelUtility;

import src.test.java.com.syntax.pages.AddEmployeesPage;
import src.test.java.com.syntax.pages.HomePage;
import src.test.java.com.syntax.pages.LoginPage;

public class AddEmployeePageTest extends BaseClass {

	@Test(dataProvider = "employee details", groups="regression")
	public void addEmployee(String fName, String mName, String lName, String location) throws InterruptedException {

		LoginPage login = new LoginPage();
		HomePage home = new HomePage();
		AddEmployeesPage addEmp = new AddEmployeesPage();
		// login to the OrangeHRM
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		// navigate to add Employee
		CommonMethods.click(home.pimBtn);
		CommonMethods.click(home.addEmp);
		// enter employee details
		CommonMethods.sendText(addEmp.firstName, fName);
		CommonMethods.sendText(addEmp.middleName, mName);
		CommonMethods.sendText(addEmp.lastName, lName);
		CommonMethods.click(addEmp.location);
		CommonMethods.selectList(addEmp.locationList, location);
		CommonMethods.click(addEmp.saveBtn);
		// verify employee is added
		CommonMethods.waitForElementBeClickable(addEmp.empCheck, 20);
		String verifText = addEmp.empCheck.getText();
		System.out.println(verifText);
		Assert.assertEquals(verifText, fName + " " + lName);
	}
	@DataProvider(name="Employee Data")
public Object[][] getEmpData() {
        
        ExcelUtility  obj=new ExcelUtility();
        obj.openExcel(Constants.XL_FILEPATH, "Loc");
        
        int rows=obj.getRowNum();//13
        int cols=obj.getColNum(0);//4
        
        Object[][] data=new Object[rows-1][cols];//new Object[12][4]
        
        for (int i=1; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                String value=obj.getCellData(i, j);
                //at first iteration data[1][0]
                
                //at last iteration data[12][3]
                data[i-1][j]=value;//data[0][0];
            }
        }
        return data;
}
@DataProvider(name="employee details")
public Object [][]getData() throws Exception{
	
	File src= new File("C:\\Users\\Samsung\\Desktop\\test2.xlsx");
	FileInputStream fis = new FileInputStream(src);
	XSSFWorkbook wb= new XSSFWorkbook(fis);
	XSSFSheet sheet= wb.getSheet("Location");
	
	int rowNum=sheet.getLastRowNum();
	int colNum= sheet.getRow(0).getLastCellNum();
	System.out.println("Row number is : "+rowNum);
	System.out.println("Column number is : "+colNum);
	
	Object[][] data=new Object[rowNum][colNum];
	for(int i=0; i<rowNum; i++) {
		for(int x=0; x<colNum; x++) {
			
			data[i][x]= sheet.getRow(i+1).getCell(x).getStringCellValue();
			
			System.out.println(data);
		}
	}
	wb.close();
	return data;
	
	
}
		


}
