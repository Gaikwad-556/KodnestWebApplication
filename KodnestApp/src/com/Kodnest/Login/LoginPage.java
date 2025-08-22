package com.Kodnest.Login;

import java.sql.SQLException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
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
	public void InvalidEmailFormat() throws SQLException {
		String query = pageModel.queryInvalidEmailFormat;
		List<String[]> data = pageModel.dbData(query);
		for(String[] i:data) {
			String email = i[0];
			String password = i[1];
			String result = i[2];
			
			pageModel.enterEmail(email);
			pageModel.enterPassword(password);
			pageModel.loginButton();
			
//			error check assert
			Assert.assertEquals(pageModel.InvalidEmailExcepted(), result);
			
//			refresh page
			driver.navigate().refresh();
		}
		
	}
	
//	Incorrect Credentials
	@Test(priority = 2)
	public void IncorrectCredentials() throws SQLException {
		String query = pageModel.queryIncorrectCredentials;
		List<String[]> data = pageModel.dbData(query);
		for(String[] i:data) {
			String email = i[0];
			String password = i[1];
			String result = i[2];
			
			pageModel.enterEmail(email);
			pageModel.enterPassword(password);
			pageModel.loginButton();
			
//			error check assert
			Assert.assertEquals(pageModel.IncorrectCredentials(), result);
			
//			refresh page
			driver.navigate().refresh();
		}
	}
	
//	User Not Found
	@Test(priority = 3)
	public void UserNotFound() throws SQLException {
		String query = pageModel.queryUserNotFound;
		List<String[]> data = pageModel.dbData(query);
		for(String[] i:data) {
			String email = i[0];
			String password = i[1];
			String result = i[2];
			
			pageModel.enterEmail(email);
			pageModel.enterPassword(password);
			pageModel.loginButton();
			
//			error check assert
			Assert.assertEquals(pageModel.UserNotFound(), result);	
			
//			refresh page
			driver.navigate().refresh();
		}
	}
	
//	Email and Password Field Blank
	@Test(priority = 4) 
	public void EmailPasswordFieldBlank() throws SQLException {
		String query = pageModel.queryFieldEmpty;
		List<String[]> data = pageModel.dbData(query);
		for(String[] i:data) {
			String email = i[0];
			String password = i[1];
			String emailResult =i[2].split(",")[0];
			String passwordResult =i[2].split(",")[1];
			
			pageModel.enterEmail(email);
			pageModel.enterPassword(password);
			pageModel.loginButton();
			
//			error check assert
			Assert.assertEquals(pageModel.EmailRequiredExpected(), emailResult);
			Assert.assertEquals(pageModel.PasswordRequiredExpected(), passwordResult);
			
//			refresh page
			driver.navigate().refresh();
		}
	}
	
//	Toggle Password
	@Test(priority = 5)
	public void togglePassword() throws InterruptedException, SQLException {
		String query = pageModel.queryUserNotFound;
		List<String[]> data = pageModel.dbData(query);
		for(String[] i:data) {
			String password = i[1];
			pageModel.enterPassword(password);
			
//			error check assert
			Assert.assertEquals(pageModel.passwordType(), "password");
			pageModel.clickToggle();
			Assert.assertEquals(pageModel.passwordType(), "text");
			pageModel.clickToggle();
			Assert.assertEquals(pageModel.passwordType(), "password");
			
//			refresh page
			driver.navigate().refresh();
		}
		
	}
	
//	Valid login
	@Test(priority = 6) 
	public void ValidLogin() throws SQLException {
		String query = pageModel.queryVaildLogin;
		List<String[]> data = pageModel.dbData(query);
		
		for(String[] i:data) {
			String email = i[0];
			String password = i[1];
			pageModel.enterEmail(email);
			pageModel.enterPassword(password);
			pageModel.loginButton();
			
//			refresh page
			driver.navigate().refresh();
		}	
	}

//	quite
	@AfterTest
	public void clean() {
		pageModel.clear();
	}

}
