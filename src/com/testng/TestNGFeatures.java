package com.testng;

import org.testng.annotations.Test;

public class TestNGFeatures {
	
	@Test
	public void LoginTest() {
		System.out.println("Login");
		
	}
	
	@Test(dependsOnMethods="LoginTest")
	public void HomePageTest() {
		System.out.println("Home Page");
	
	}
	
	@Test(dependsOnMethods="HomePageTest")
	public void SearchPage() {
		System.out.println("Search Page");
	}

}
