package com.Kodnest.Registration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utils.DatabaseUtils;

public class RegistrationPOM {
	
	private WebDriver driver;
	
//	Constructor
	public RegistrationPOM(WebDriver driver) throws SQLException {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	
	
//	locators
	@FindBy(id = "form-field-name")
	private WebElement nameField;
	
	@FindBy(id = "form-field-email")
	private WebElement emailField;
	
	@FindBy(id = "form-field-field_4fbbd89")
	private WebElement phoneField;
	
	@FindBy(id = "form-field-field_8fa87fb")
	private WebElement whatsappNumberField;
	
	@FindBy(id = "form-field-field_5b5f7aa")
	private WebElement referredField;
	
	@FindBy(css = ".elementor-button")
	private WebElement registerButton;
	
	@FindBy(id = "form-field-field_5973204-0")
	private WebElement onlineRadio;
	
	@FindBy(id = "form-field-field_5973204-1")
	private WebElement offlineRadio;
	
	@FindBy(id = "form-field-field_2788795-0")
	private WebElement developmentRadio;
	
	@FindBy(id = "form-field-field_2788795-1")
	private WebElement testingRadio;
	
	@FindBy(id = "form-field-field_670c01a")
	private WebElement year;
	
	@FindBy(id = "form-field-field_aa6903c")
	private WebElement language;

	
//	METHODS
	
//	Name Field	
	public void dataName(String name) {
		nameField.sendKeys(name);
	}
	
//	Email Field	
	public void dataEmail(String email) {
		emailField.sendKeys(email);
	}
	
//	Phone Field	
	public void dataPhone(String phone) {
		phoneField.sendKeys(phone);
	}
	
//	WhatsApp Phone Field	
	public void dataWhatsapp(String phone) {
		whatsappNumberField.sendKeys(phone);
	}
	
//	Referred Field	
	public void dataReferred(String refer) {
		referredField.sendKeys(refer);
	}
	
//	Online radio button	
	public void onlineSelect() {
		onlineRadio.click();
	}
	
//	Offline radio button	
	public void offlineSelect() {
		offlineRadio.click();
	}
	
//	Development radio button	
	public void developmentSelect() {
		developmentRadio.click();
	}
	
//	Testing radio button	
	public void testingSelect() {
		testingRadio.click();
	}
	
//	Registration Button
	public void buttonClick() {
		onlineRadio.click();
	}
	
//	Graduation Drop Down
	public void graduationYear(int index) {
		Select gYear = new Select(year);
		if(index<=6 && index > 0) {
			gYear.selectByIndex(index);
		}
		else {
			gYear.selectByIndex(0);
		}
	}
	
//	Language Drop Down
	public void language(int index) {
		Select lang = new Select(language);
		if(index<=6 && index > 0) {
			lang.selectByIndex(index);
		}
		else {
			lang.selectByIndex(0);
		}	
	}
	
//	assert methods
//	validate fields
	public void validateField() {
		// Assert.assertEquals(excepted error, actual error);
	}
	
	
//	clear
	public void clear() throws SQLException {
		DatabaseUtils.close();
		driver.quit();
	}	
}
