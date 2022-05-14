package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	
	// Pre Condition Annotation
	@BeforeSuite //1
	
	public void setUp() {
		System.out.println("Setting up the property for chrome");
	}
	
@BeforeTest   //2
	
	public void launchBrowser() {
		System.out.println("Launching chrome");
	}
	
	@BeforeClass  //3
	
	public void login() {
		System.out.println("Login in App");
	}
	
	@BeforeMethod    //4
	
	public void enterURL()
	{
		System.out.println("Enter URL");
	}
	
	
	
	
	
	
	//Test Case
	
	@Test   //5
	
	public void GetGoogleTittleText() {
		System.out.println("Google title text");
	}
	
@Test   //5
	
	public void GetGoogleText() {
		System.out.println("Google text");
	}
	
@Test   //5

public void GetGoogleLogo() {
	System.out.println("Google");
}
	
	// Post Annotation
	
	@AfterMethod  //6
	
	public void LogOut() {
		System.out.println("Log Out from App");
	}
	
	@AfterClass  //7
	public void CloseBrowser() {
		System.out.println("Closing Browser");
	}
	@AfterTest   //8
	
	public void deleteCookies() {
		System.out.println("Delete Cookies");
	}
	
	
	@AfterSuite //9
	public void GenerateReports() {
		System.out.println("Generate Reports");
	}

}
