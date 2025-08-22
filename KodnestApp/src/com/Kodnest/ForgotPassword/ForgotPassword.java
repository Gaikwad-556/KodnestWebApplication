package com.Kodnest.ForgotPassword;


import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


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
	public void invalidEmailFormat() throws SQLException {
		String query = fpModel.queryInvalidFormatEmail;
		
		List<String[]> data = fpModel.dbdata(query);
		for(int i=0; i<data.size(); i++) {
			String email=data.get(i)[0];
			String result=data.get(i)[1];
			
			fpModel.enterEmailField(email);
			fpModel.sendLinkButton();
			
//		error check assert
			Assert.assertEquals(fpModel.emailError(), result);
			
//			refresh page
			driver.navigate().refresh();
		}	
	}
	
//	empty field
	@Test(priority = 2)
	public void emptyField() throws SQLException {
		String query = fpModel.queryEmptyField;
		
		List<String[]> data = fpModel.dbdata(query);
		for(int i=0; i<data.size(); i++) {
			String email=data.get(i)[0];
			String result=data.get(i)[1];
			
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
	public void invalidUser() throws SQLException {
		String query = fpModel.queryinvalidEmail;
		
		List<String[]> data = fpModel.dbdata(query);
		for(int i=0; i<data.size(); i++) {
			String email=data.get(i)[0];
			String result=data.get(i)[1];
			
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
	public void validUser() throws SQLException {
		String query = fpModel.queryValidEmail;
		
		List<String[]> data = fpModel.dbdata(query);
		for(int i=0; i<data.size(); i++) {
			String email=data.get(i)[0];
//			String result=data.get(i)[1];
			
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
