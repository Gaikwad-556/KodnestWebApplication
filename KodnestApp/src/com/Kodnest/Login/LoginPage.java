package com.Kodnest.Login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.DatabaseUtils;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;

public class LoginPage {
	WebDriver driver;
	LoginPageModel pageModel;
	
	@BeforeTest
	@Parameters("loginurl")
	public void InitialSetUp(String loginurl) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(loginurl);
		pageModel = new LoginPageModel(driver);
	}
	
//	Invalid Email Format
	@Test(priority = 1)
	public void InvalidEmailFormat() throws SQLException, FileNotFoundException, IOException {
//		query parameters
		String status = "fail";
		String testingType = "invalidemailformat";
		String queryOf = "loginPageQuery";
		
//		database data
		List<Map<String, String>> data = DatabaseUtils.getTestData(status, testingType, queryOf);
		
//		interacting with browser
		for(Map<String,String> i:data) {
			String email = i.get("email");
			String password = i.get("password");
			String result = i.get("result");
			
			pageModel.enterEmail(email);
			pageModel.enterPassword(password);
			pageModel.loginButton();
			
//			error check assert
			Assert.assertEquals(pageModel.InvalidEmailExcepted(), result);
			
//			field clear
			pageModel.fieldClear();
		}
		
	}
	
//	Incorrect Credentials
	@Test(priority = 2)
	public void IncorrectCredentials() throws SQLException, FileNotFoundException, IOException {
//		query parameters
		String status = "fail";
		String testingType = "incorrectcredentials";
		String queryOf = "loginPageQuery";
		
//		database data
		List<Map<String, String>> data = DatabaseUtils.getTestData(status, testingType, queryOf);
		
//		interacting with browser
		for(Map<String,String> i:data) {
			String email = i.get("email");
			String password = i.get("password");
			String result = i.get("result");
			
			pageModel.enterEmail(email);
			pageModel.enterPassword(password);
			pageModel.loginButton();
			
//			error check assert
			Assert.assertEquals(pageModel.IncorrectCredentials(), result);
			
//			field clear
			pageModel.fieldClear();
		}
	}
	
//	User Not Found
	@Test(priority = 3)
	public void UserNotFound() throws SQLException, FileNotFoundException, IOException {
//		query parameters
		String status = "fail";
		String testingType = "usernotfound";
		String queryOf = "loginPageQuery";

//		database data
		List<Map<String, String>> data = DatabaseUtils.getTestData(status, testingType, queryOf);
		
//		interacting with browser
		for(Map<String,String> i:data) {
			String email = i.get("email");
			String password = i.get("password");
			String result = i.get("result");
			
			pageModel.enterEmail(email);
			pageModel.enterPassword(password);
			pageModel.loginButton();
			
//			error check assert
			Assert.assertEquals(pageModel.UserNotFound(), result);	
			
//			field clear
			pageModel.fieldClear();
		}
	}
	
//	Email and Password Field Blank
	@Test(priority = 4) 
	public void EmailPasswordFieldBlank() throws SQLException, FileNotFoundException, IOException {
//		query parameters
		String status = "fail";
		String testingType = "emailpasswordfieldblank";
		String queryOf = "loginPageQuery";
		
//		database data
		List<Map<String, String>> data = DatabaseUtils.getTestData(status, testingType, queryOf);
		
//		interacting with browser
		for(Map<String,String> i:data) {
			String email = i.get("email");
			String password = i.get("password");
			String emailResult = i.get("result").split(",")[0];
			String passwordResult = i.get("result").split(",")[1];
			
			pageModel.enterEmail(email);
			pageModel.enterPassword(password);
			pageModel.loginButton();
			
//			error check assert
			Assert.assertEquals(pageModel.EmailRequiredExpected(), emailResult);
			Assert.assertEquals(pageModel.PasswordRequiredExpected(), passwordResult);
			
//			field clear
			pageModel.fieldClear();
		}
	}
	
//	Toggle Password
	@Test(priority = 5)
	public void togglePassword() throws InterruptedException, SQLException, FileNotFoundException, IOException {
//		query parameters
		String status = "fail";
		String testingType = "invalidemailformat";
		String queryOf = "loginPageQuery";
		
//		database data
		List<Map<String, String>> data = DatabaseUtils.getTestData(status, testingType, queryOf);
		
//		interacting with browser
		for(Map<String,String> i:data) {
			String password = i.get("password");
			
			pageModel.enterPassword(password);
			
//			error check assert
			Assert.assertEquals(pageModel.passwordType(), "password");
			pageModel.clickToggle();
			Assert.assertEquals(pageModel.passwordType(), "text");
			pageModel.clickToggle();
			Assert.assertEquals(pageModel.passwordType(), "password");
			
//			field clear
			pageModel.fieldClear();
		}
	}
	
	
//	Valid login
	@Test(priority = 6) 
	public void ValidLogin() throws SQLException, FileNotFoundException, IOException {
//		query parameters
		String status = "pass";
		String testingType = "validlogin";
		String queryOf = "loginPageQuery";
		
//		database data
		List<Map<String, String>> data = DatabaseUtils.getTestData(status, testingType, queryOf);
		
//		interacting with browser
		for(Map<String,String> i:data) {
			String email = i.get("email");
			String password = i.get("password");
			
			pageModel.enterEmail(email);
			pageModel.enterPassword(password);
			pageModel.loginButton();
			
//			field clear
			pageModel.fieldClear();
		}	
	}

//	quit
	@AfterTest
	public void clean() throws SQLException {
		pageModel.clear();
	}

}
