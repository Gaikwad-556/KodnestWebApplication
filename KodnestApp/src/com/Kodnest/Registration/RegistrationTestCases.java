package com.Kodnest.Registration;

import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
	public void numericValueInNameField() throws SQLException {
//		query 
		String query = rPOM.query_numericValueInNameField;
		
//		list of data from db
		List<String[]> data = rPOM.dbdata(query);
		for(String[] i:data) {		
//			getting value from list
			String name = i[0];
			String email = i[1];
			String phone = i[2];
			String referredId = i[3];
			String result = i[4];
			
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
	public void specialValueInNameField() throws SQLException {
//		query
		String query = rPOM.query_specialValueInNameField;
//		list of data from db
		List<String[]> data = rPOM.dbdata(query);
		for(String[] i:data) {
//			getting value from list
			String name = i[0];
			String email = i[1];
			String phone = i[2];
			String referredId = i[3];
			String result = i[4];
			
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
	public void allFieldBlank() throws SQLException {
//		query
		String query = rPOM.query_allFieldBlank;
//		list of data from db
		List<String[]> data = rPOM.dbdata(query);
		for(String[] i:data) {
//			getting value from list
			String name = i[0];
			String email = i[1];
			String phone = i[2];
			String referredId = i[3];
			String result = i[4];
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
	public void invalidFormatedEmailEntry() throws SQLException {
//		query
		String query = rPOM.query_invalidFormatedEmailEntry;
//		list of data from db
		List<String[]> data = rPOM.dbdata(query);
		for(String[] i:data) {
//			getting value from list
			String name = i[0];
			String email = i[1];
			String phone = i[2];
			String referredId = i[3];
			String result = i[4];
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
	public void registeredEmailEntry() throws SQLException {
//		query
		String query = rPOM.query_registeredEmailEntry;
//		list of data from db
		List<String[]> data = rPOM.dbdata(query);
		for(String[] i:data) {
//			getting value from list
			String name = i[0];
			String email = i[1];
			String phone = i[2];
			String referredId = i[3];
			String result = i[4];
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
	public void negativePhoneEntry() throws SQLException {
//		query
		String query = rPOM.query_negativePhoneEntry;
//		list of data from db
		List<String[]> data = rPOM.dbdata(query);
		for(String[] i:data) {
//			getting value from list
			String name = i[0];
			String email = i[1];
			String phone = i[2];
			String referredId = i[3];
			String result = i[4];
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
	public void lesserThanTenDigitPhoneAndWhatsappEntry() throws SQLException {
//		query
		String query = rPOM.query_lesserThanTenDigitPhoneAndWhatsappEntry;
//		list of data from db
		List<String[]> data = rPOM.dbdata(query);
		for(String[] i:data) {
//			getting value from list
			String name = i[0];
			String email = i[1];
			String phone = i[2];
			String referredId = i[3];
			String result = i[4];
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
	public void moreThanTenDigitPhoneAndWhatsappEntry() throws SQLException {
//		query
		String query = rPOM.query_moreThanTenDigitPhoneAndWhatsappEntry;	
//		list of data from db
		List<String[]> data = rPOM.dbdata(query);
		for(String[] i:data) {
//			getting value from list
			String name = i[0];
			String email = i[1];
			String phone = i[2];
			String referredId = i[3];
			String result = i[4];
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
	public void graduationYearDropDown() throws SQLException {
//		query
		String query = rPOM.query_allValidInputs;
//		list of data from db
		List<String[]> data = rPOM.dbdata(query);
		for(String[] i:data) {
//			getting value from list
			String name = i[0];
			String email = i[1];
			String phone = i[2];
			String referredId = i[3];
			String result = i[4];
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
	public void languageDropDown() throws SQLException {
//		query
		String query = rPOM.query_allValidInputs;
//		list of data from db
		List<String[]> data = rPOM.dbdata(query);
		for(String[] i:data) {
//			getting value from list
			String name = i[0];
			String email = i[1];
			String phone = i[2];
			String referredId = i[3];
			String result = i[4];
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
	public void nonExistingUserReferralEntry() throws SQLException {
//		query
		String query = rPOM.query_nonExistingUserReferralEntry;
//		list of data from db
		List<String[]> data = rPOM.dbdata(query);
		for(String[] i:data) {
//			getting value from list
			String name = i[0];
			String email = i[1];
			String phone = i[2];
			String referredId = i[3];
			String result = i[4];
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
	public void allValidInputs() throws SQLException {
//		query
		String query = rPOM.query_allValidInputs;
//		list of data from db
		List<String[]> data = rPOM.dbdata(query);
		for(String[] i:data) {
//			getting value from list
			String name = i[0];
			String email = i[1];
			String phone = i[2];
			String referredId = i[3];
			String result = i[4];
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

//	quite
	@AfterTest
	public void clean() throws SQLException {
		rPOM.clear();
	}
}
