package com.DataDriver.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args) {
		
		
		
		Xls_Reader reader=new Xls_Reader("C:\\Users\\hp\\eclipse-workspace\\SeleniumSessions\\src\\com\\testData\\halfebaytestdata.xlsx");
		
		String name=reader.getCellData("TestData","name",2 );// sheetname,column_name and row number
		System.out.println(name);
		String email=reader.getCellData("TestData","email",2 );// sheetname,column_name and row number
		System.out.println(email);
		String password=reader.getCellData("TestData","password",2 );// sheetname,column_name and row number
		System.out.println(password);
		String location=reader.getCellData("TestData","location",2 );// sheetname,column_name and row number
		System.out.println(location);
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	
		
		
		driver.get("https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2F");
		
        driver.findElement(By.id("businessaccount-radio")).click();
		
		driver.findElement(By.id("businessName")).sendKeys(name);
		driver.findElement(By.cssSelector("#businessEmail")).sendKeys(email);
		driver.findElement(By.name("bizPassword")).sendKeys(password);
		
		Select select=new Select(driver.findElement(By.id("businessCountry")));
		select.selectByVisibleText(location);
		
		driver.findElement(By.id("bizOnlyToBuy")).click();
		//driver.findElement(By.id("BUSINESS_REG_FORM_SUBMIT")).click();
	}

}
