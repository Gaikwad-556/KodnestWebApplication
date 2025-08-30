package com.Kodnest.Registration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.DatabaseUtils;

public class RegistrationTestCases {
	WebDriver driver;
	RegistrationPOM rPOM;
	
//	Before Test Method
	@BeforeTest
	@Parameters("registrationurl")
	public void setup(String registrationurl) throws SQLException {
		driver = new ChromeDriver();
		driver.get(registrationurl);
		driver.manage().window().maximize();
		rPOM = new RegistrationPOM(driver);
	}
	
//	Test Cases
	
//	Numeric Value In Name Field
	@Test(priority = 1) 
	public void numericValueInNameField() throws SQLException, FileNotFoundException, IOException {
//		query parameters
		String status = "fail";
		String testingType = "numericValueInNameField";
		String queryOf = "registrationQuery";
		
//		database data
		List<Map<String, String>> data = DatabaseUtils.getTestData(status, testingType, queryOf);
		
//		interacting with browser
		for(Map<String, String> i:data) {		
			String name = i.get("name");
			String email = i.get("email");
			String phone = i.get("phone");
			String referredId = i.get("referredId");
//			String result = i.get("result");
			
//			sending value to fields
			rPOM.dataName(name);
			rPOM.dataEmail(email);
			rPOM.dataPhone(phone);
			rPOM.dataWhatsapp(phone);
			rPOM.graduationYear(2);
			rPOM.language(2);
			rPOM.dataReferred(referredId);
			rPOM.onlineSelect();
			rPOM.developmentSelect();
//			rPOM.buttonClick();
			
//			assert check
//			rPOM.validateField(result);
			
//			refresh page
			driver.navigate().refresh();
		}
	}
	
//	Special Value In Name Field
	@Test(priority = 2) 
	public void specialValueInNameField() throws SQLException, FileNotFoundException, IOException {
//		query parameters
		String status = "fail";
		String testingType = "specialValueInNameField";
		String queryOf = "registrationQuery";
		
//		database data
		List<Map<String, String>> data = DatabaseUtils.getTestData(status, testingType, queryOf);
		
//		interacting with browser
		for(Map<String, String> i:data) {		
			String name = i.get("name");
			String email = i.get("email");
			String phone = i.get("phone");
			String referredId = i.get("referredId");
//			String result = i.get("result");
			
//			sending value to fields
			rPOM.dataName(name);
			rPOM.dataEmail(email);
			rPOM.dataPhone(phone);
			rPOM.dataWhatsapp(phone);
			rPOM.graduationYear(2);
			rPOM.language(2);
			rPOM.dataReferred(referredId);
			rPOM.onlineSelect();
			rPOM.developmentSelect();
//			rPOM.buttonClick();
			
//			assert check
//			rPOM.validateField(result);
			
//			refresh page
			driver.navigate().refresh();
		}
	}
	
//	All field blank
	@Test(priority = 3) 
	public void allFieldBlank() throws SQLException, FileNotFoundException, IOException {
//		query parameters
		String status = "fail";
		String testingType = "allFieldBlank";
		String queryOf = "registrationQuery";
		
//		database data
		List<Map<String, String>> data = DatabaseUtils.getTestData(status, testingType, queryOf);
		
//		interacting with browser
		for(Map<String, String> i:data) {		
			String name = i.get("name");
			String email = i.get("email");
			String phone = i.get("phone");
			String referredId = i.get("referredId");
//			String result = i.get("result");
			
//			sending value to fields
			rPOM.dataName(name);
			rPOM.dataEmail(email);
			rPOM.dataPhone(phone);
			rPOM.dataWhatsapp(phone);
			rPOM.graduationYear(0);
			rPOM.language(0);
			rPOM.dataReferred(referredId);
//			rPOM.buttonClick();

//			assert check
//			rPOM.validateField(result);
			
//			refresh page
			driver.navigate().refresh();
		}
	}
	
//	Invalid Formated Email
	@Test(priority = 4) 
	public void invalidFormatedEmailEntry() throws SQLException, FileNotFoundException, IOException {
//		query parameters
		String status = "fail";
		String testingType = "invalidFormatedEmailEntry";
		String queryOf = "registrationQuery";
		
//		database data
		List<Map<String, String>> data = DatabaseUtils.getTestData(status, testingType, queryOf);
		
//		interacting with browser
		for(Map<String, String> i:data) {		
			String name = i.get("name");
			String email = i.get("email");
			String phone = i.get("phone");
			String referredId = i.get("referredId");
//			String result = i.get("result");
			
//			sending value to fields
			rPOM.dataName(name);
			rPOM.dataEmail(email);
			rPOM.dataPhone(phone);
			rPOM.dataWhatsapp(phone);
			rPOM.graduationYear(2);
			rPOM.language(2);
			rPOM.dataReferred(referredId);
			rPOM.onlineSelect();
			rPOM.developmentSelect();
//			rPOM.buttonClick();
			
//			assert check
//			rPOM.validateField(result);
			
//			refresh page
			driver.navigate().refresh();
		}
	}
	
//	Registered Email
	@Test(priority = 5) 
	public void registeredEmailEntry() throws SQLException, FileNotFoundException, IOException {
//		query parameters
		String status = "fail";
		String testingType = "registeredEmailEntry";
		String queryOf = "registrationQuery";
		
//		database data
		List<Map<String, String>> data = DatabaseUtils.getTestData(status, testingType, queryOf);
		
//		interacting with browser
		for(Map<String, String> i:data) {		
			String name = i.get("name");
			String email = i.get("email");
			String phone = i.get("phone");
			String referredId = i.get("referredId");
//			String result = i.get("result");
			
//			sending value to fields
			rPOM.dataName(name);
			rPOM.dataEmail(email);
			rPOM.dataPhone(phone);
			rPOM.dataWhatsapp(phone);
			rPOM.graduationYear(2);
			rPOM.language(2);
			rPOM.dataReferred(referredId);
			rPOM.onlineSelect();
			rPOM.developmentSelect();
//			rPOM.buttonClick();
			
//			assert check		
//			rPOM.validateField(result);
			
//			refresh page
			driver.navigate().refresh();
		}
	}
	
//	Negative Phone Number
	@Test(priority = 6) 
	public void negativePhoneEntry() throws SQLException, FileNotFoundException, IOException {
//		query parameters
		String status = "fail";
		String testingType = "negativePhoneEntry";
		String queryOf = "registrationQuery";
		
//		database data
		List<Map<String, String>> data = DatabaseUtils.getTestData(status, testingType, queryOf);
		
//		interacting with browser
		for(Map<String, String> i:data) {		
			String name = i.get("name");
			String email = i.get("email");
			String phone = i.get("phone");
			String referredId = i.get("referredId");
//			String result = i.get("result");
			
//			sending value to fields
			rPOM.dataName(name);
			rPOM.dataEmail(email);
			rPOM.dataPhone(phone);
			rPOM.dataWhatsapp(phone);
			rPOM.graduationYear(2);
			rPOM.language(2);
			rPOM.dataReferred(referredId);
			rPOM.onlineSelect();
			rPOM.developmentSelect();
//			rPOM.buttonClick();
			
//			assert check
//			rPOM.validateField(result);
			
//			refresh page
			driver.navigate().refresh();
		}
	}
	
//	Entered less than 10 digit phone number
	@Test(priority = 7) 
	public void lesserThanTenDigitPhoneAndWhatsappEntry() throws SQLException, FileNotFoundException, IOException {
//		query parameters
		String status = "fail";
		String testingType = "lesserThanTenDigitPhoneAndWhatsappEntry";
		String queryOf = "registrationQuery";
		
//		database data
		List<Map<String, String>> data = DatabaseUtils.getTestData(status, testingType, queryOf);
		
//		interacting with browser
		for(Map<String, String> i:data) {		
			String name = i.get("name");
			String email = i.get("email");
			String phone = i.get("phone");
			String referredId = i.get("referredId");
//			String result = i.get("result");
			
//			sending value to fields
			rPOM.dataName(name);
			rPOM.dataEmail(email);
			rPOM.dataPhone(phone);
			rPOM.dataWhatsapp(phone);
			rPOM.graduationYear(2);
			rPOM.language(2);
			rPOM.dataReferred(referredId);
			rPOM.onlineSelect();
			rPOM.developmentSelect();
//			rPOM.buttonClick();
			
//			assert check
//			rPOM.validateField(result);
			
//			refresh page
			driver.navigate().refresh();
		}
	}
	
//	Entered more than 10 digit phone number
	@Test(priority = 8) 
	public void moreThanTenDigitPhoneAndWhatsappEntry() throws SQLException, FileNotFoundException, IOException {
//		query parameters
		String status = "fail";
		String testingType = "moreThanTenDigitPhoneAndWhatsappEntry";
		String queryOf = "registrationQuery";
		
//		database data
		List<Map<String, String>> data = DatabaseUtils.getTestData(status, testingType, queryOf);
		
//		interacting with browser
		for(Map<String, String> i:data) {		
			String name = i.get("name");
			String email = i.get("email");
			String phone = i.get("phone");
			String referredId = i.get("referredId");
//			String result = i.get("result");
			
//			sending value to fields
			rPOM.dataName(name);
			rPOM.dataEmail(email);
			rPOM.dataPhone(phone);
			rPOM.dataWhatsapp(phone);
			rPOM.graduationYear(2);
			rPOM.language(2);
			rPOM.dataReferred(referredId);
			rPOM.onlineSelect();
			rPOM.developmentSelect();
//			rPOM.buttonClick();
			
//			assert check
//			rPOM.validateField(result);
			
//			refresh page
			driver.navigate().refresh();
		}
	}
	
//	Graduation Year Drop Down
	@Test(priority = 9) 
	public void graduationYearDropDown() throws SQLException, FileNotFoundException, IOException {
//		query parameters
		String status = "pass";
		String testingType = "allValidInputs";
		String queryOf = "registrationQuery";
		
//		database data
		List<Map<String, String>> data = DatabaseUtils.getTestData(status, testingType, queryOf);
		
//		interacting with browser
		for(Map<String, String> i:data) {		
			String name = i.get("name");
			String email = i.get("email");
			String phone = i.get("phone");
			String referredId = i.get("referredId");
//			String result = i.get("result");
			
//			sending value to fields
			rPOM.dataName(name);
			rPOM.dataEmail(email);
			rPOM.dataPhone(phone);
			rPOM.dataWhatsapp(phone);
			rPOM.graduationYear(3);
			rPOM.language(2);
			rPOM.dataReferred(referredId);
			rPOM.offlineSelect();
			rPOM.testingSelect();
//			rPOM.buttonClick();
			
//			assert check
//			rPOM.validateField(result);
			
//			refresh page
			driver.navigate().refresh();
		}
	}
	
//	Language Drop Down
	@Test(priority = 10) 
	public void languageDropDown() throws SQLException, FileNotFoundException, IOException {
//		query parameters
		String status = "pass";
		String testingType = "allValidInputs";
		String queryOf = "registrationQuery";
		
//		database data
		List<Map<String, String>> data = DatabaseUtils.getTestData(status, testingType, queryOf);
		
//		interacting with browser
		for(Map<String, String> i:data) {		
			String name = i.get("name");
			String email = i.get("email");
			String phone = i.get("phone");
			String referredId = i.get("referredId");
//			String result = i.get("result");
			
//			sending value to fields
			rPOM.dataName(name);
			rPOM.dataEmail(email);
			rPOM.dataPhone(phone);
			rPOM.dataWhatsapp(phone);
			rPOM.graduationYear(2);
			rPOM.language(3);
			rPOM.dataReferred(referredId);
			rPOM.offlineSelect();
			rPOM.testingSelect();
//			rPOM.buttonClick();
			
//			assert check
//			rPOM.validateField(result);
			
//			refresh page
			driver.navigate().refresh();
		}
	}
	
//	Non Existing User Referral
	@Test(priority = 11) 
	public void nonExistingUserReferralEntry() throws SQLException, FileNotFoundException, IOException {
//		query parameters
		String status = "fail";
		String testingType = "nonExistingUserReferralEntry";
		String queryOf = "registrationQuery";

//		database data
		List<Map<String, String>> data = DatabaseUtils.getTestData(status, testingType, queryOf);
		
//		interacting with browser
		for(Map<String, String> i:data) {		
			String name = i.get("name");
			String email = i.get("email");
			String phone = i.get("phone");
			String referredId = i.get("referredId");
//			String result = i.get("result");
			
//			sending value to fields
			rPOM.dataName(name);
			rPOM.dataEmail(email);
			rPOM.dataPhone(phone);
			rPOM.dataWhatsapp(phone);
			rPOM.graduationYear(2);
			rPOM.language(2);
			rPOM.dataReferred(referredId);
			rPOM.offlineSelect();
			rPOM.testingSelect();
//			rPOM.buttonClick();
			
//			assert check
//			rPOM.validateField(result);
			
//			refresh page
			driver.navigate().refresh();
		}
	}
	
//	All valid entry
	@Test(priority = 12) 
	public void allValidInputs() throws SQLException, FileNotFoundException, IOException {
//		query parameters
		String status = "pass";
		String testingType = "allValidInputs";
		String queryOf = "registrationQuery";
		
//		database data
		List<Map<String, String>> data = DatabaseUtils.getTestData(status, testingType, queryOf);
		
//		interacting with browser
		for(Map<String, String> i:data) {		
			String name = i.get("name");
			String email = i.get("email");
			String phone = i.get("phone");
			String referredId = i.get("referredId");
//			String result = i.get("result");
			
//			sending value to fields
			rPOM.dataName(name);
			rPOM.dataEmail(email);
			rPOM.dataPhone(phone);
			rPOM.dataWhatsapp(phone);
			rPOM.graduationYear(2);
			rPOM.language(2);
			rPOM.dataReferred(referredId);
			rPOM.offlineSelect();
			rPOM.testingSelect();
//			rPOM.buttonClick();
			
//			assert check
//			rPOM.validateField(result);
			
//			refresh page
			driver.navigate().refresh();
		}
	}

//	quit
	@AfterTest
	public void clean() throws SQLException {
		rPOM.clear();
	}
}
