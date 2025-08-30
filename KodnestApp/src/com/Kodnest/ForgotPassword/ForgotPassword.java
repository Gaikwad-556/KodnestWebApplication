package com.Kodnest.ForgotPassword;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.DatabaseUtils;


public class ForgotPassword {
	WebDriver driver;
	ForgotPasswordModel fpModel;
	
	@BeforeTest
	@Parameters("passwordrecoveryurl")
	public void setUp(String siteurl) throws SQLException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(siteurl);
		fpModel = new ForgotPasswordModel(driver);	
	}
	
//	Invalid Email Format
	@Test(priority = 1)
	public void invalidEmailFormat() throws SQLException, FileNotFoundException, IOException {
		String status = "fail";
		String testingType = "invalid email format";
		String queryOf = "passwordRecoveryQuery";
		
		List<Map<String, String>> data = DatabaseUtils.getTestData(status,testingType,queryOf);
		for(Map<String, String> i:data) {
			String email = i.get("email");
			String result = i.get("result");
			
			fpModel.enterEmailField(email);
			fpModel.sendLinkButton();
			
//			error check assert
			Assert.assertEquals(fpModel.emailError(), result);
			
//			refresh page
			driver.navigate().refresh();
		}	
	}
	
//	empty field
	@Test(priority = 2)
	public void emptyField() throws SQLException, FileNotFoundException, IOException {
		String status = "fail";
		String testingType = "field blank";
		String queryOf = "passwordRecoveryQuery";
		
		List<Map<String, String>> data = DatabaseUtils.getTestData(status,testingType,queryOf);
		for(Map<String, String> i:data) {
			String email = i.get("email");
			String result = i.get("result");
			
			fpModel.enterEmailField(email);
			fpModel.sendLinkButton();

//			error check assert
			Assert.assertEquals(fpModel.emailError(), result);
			
//			refresh page
			driver.navigate().refresh();
		}
	}
	
//	Invalid User
	@Test(priority = 3)
	public void invalidUser() throws SQLException, FileNotFoundException, IOException {
		String status = "fail";
		String testingType = "invalid user";
		String queryOf = "passwordRecoveryQuery";
		
		List<Map<String, String>> data = DatabaseUtils.getTestData(status,testingType,queryOf);
		for(Map<String, String> i:data) {
			String email = i.get("email");
			String result = i.get("result");
			
			fpModel.enterEmailField(email);
			fpModel.sendLinkButton();
		
//			error check assert
			Assert.assertEquals(fpModel.invalidUser(), result);
			
//			refresh page
			driver.navigate().refresh();
		}
	}
	
//	Valid User
	@Test(priority = 4)
	public void validUser() throws SQLException, FileNotFoundException, IOException {
		String status = "pass";
		String testingType = "valid email";
		String queryOf = "passwordRecoveryQuery";
		
		List<Map<String, String>> data = DatabaseUtils.getTestData(status,testingType,queryOf);
		for(Map<String, String> i:data) {
			String email = i.get("email");
//			String result = i.get("result");
			
			fpModel.enterEmailField(email);
			fpModel.sendLinkButton();
		}
	}
	
//	quite
	@AfterTest
	public void clean() throws SQLException {
		fpModel.clear();
	}
}
