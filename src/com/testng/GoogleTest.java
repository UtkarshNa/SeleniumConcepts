package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	
	WebDriver driver;
	
	
	@BeforeMethod
	// Write all pre -requiste 
	
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}
	
	@Test(priority=1,groups="Title")
	
	public void googleTittleTest() {
		String text= driver.getTitle();
		System.out.println("Title = "+ text);
		Assert.assertEquals(text, "Google");
	}
	
	@Test(priority=2,groups="Logo")
	
	public void googleImageTest() {
		boolean flag=driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed();
		System.out.println("Is Logo Visible = "+flag);
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3, groups="Link")
	
	public void gmailLinkIsVisible() {
		boolean img=driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).isDisplayed();
		System.out.println("Is Gmail Link Visible = "+img);
	}

	@Test (priority=4, groups="Test")
	public void test1() {
		System.out.println("Testing 1");
	}
	
	@Test (priority=5, groups="Test")
	public void test2() {
		System.out.println("Testing 2");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
