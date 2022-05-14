package com.DataDriver.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class ParameterizeData {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	
		
		
		driver.get("https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2F");
		
		
		Xls_Reader reader=new Xls_Reader("C:\\Users\\hp\\eclipse-workspace\\SeleniumSessions\\src\\com\\testData\\halfebaytestdata.xlsx");
		
		reader.addColumn("TestData", "Status");
		
		int rowcount=reader.getRowCount("TestData");
		
		
		
		for(int rowNum=2; rowNum<=rowcount;rowNum++) {
			
			String name=reader.getCellData("TestData","name",rowNum );
			System.out.println(name);
			String email=reader.getCellData("TestData","email",rowNum );// sheetname,column_name and row number
			System.out.println(email);
			String password=reader.getCellData("TestData","password",rowNum );// sheetname,column_name and row number
			System.out.println(password);
			String location=reader.getCellData("TestData","location",rowNum );// sheetname,column_name and row number
			System.out.println(location);
			
			
			//Driver
			
			
	        driver.findElement(By.id("businessaccount-radio")).click();
	        driver.findElement(By.id("businessName")).clear();
			driver.findElement(By.id("businessName")).sendKeys(name);
			
			driver.findElement(By.cssSelector("#businessEmail")).clear();
			driver.findElement(By.cssSelector("#businessEmail")).sendKeys(email);
			
			driver.findElement(By.name("bizPassword")).clear();
			driver.findElement(By.name("bizPassword")).sendKeys(password);
			
			Select select=new Select(driver.findElement(By.id("businessCountry")));
			select.selectByVisibleText(location);
			
			driver.findElement(By.id("bizOnlyToBuy")).click();
			//driver.findElement(By.id("BUSINESS_REG_FORM_SUBMIT")).click();
			
			reader.setCellData("TestData", "Status", rowNum, "Pass");
		}

	}

}
