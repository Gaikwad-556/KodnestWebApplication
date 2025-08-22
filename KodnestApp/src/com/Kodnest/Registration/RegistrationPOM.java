package com.Kodnest.Registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPOM {
	
	private WebDriver driver;
	private Connection con;
	
//	Constructor
	public RegistrationPOM(WebDriver driver) throws SQLException {
		super();
		this.driver = driver;
		this.con = DriverManager.getConnection(db_url,db_user,db_password);
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
	
	
//	Variable
	private String db_url = System.getenv("URL_DB");
	private String db_password = System.getenv("PASSWORD_DB");
	private String db_user = System.getenv("USER_DB");
	
	
//	query
	String query_numericValueInNameField = "select * from registrationpage where status='fail' AND testingType='numericValueInNameField'";
	String query_specialValueInNameField = "select * from registrationpage where status='fail' AND testingType='specialValueInNameField'";
	String query_allFieldBlank = "select * from registrationpage where status='fail' AND testingType='allFieldBlank'";
	String query_invalidFormatedEmailEntry = "select * from registrationpage where status='fail' AND testingType='invalidFormatedEmailEntry'";
	String query_registeredEmailEntry = "select * from registrationpage where status='fail' AND testingType='registeredEmailEntry'";
	String query_negativePhoneEntry = "select * from registrationpage where status='fail' AND testingType='negativePhoneEntry'";
	String query_lesserThanTenDigitPhoneAndWhatsappEntry = "select * from registrationpage where status='fail' AND testingType='lesserThanTenDigitPhoneAndWhatsappEntry'";
	String query_moreThanTenDigitPhoneAndWhatsappEntry = "select * from registrationpage where status='fail' AND testingType='moreThanTenDigitPhoneAndWhatsappEntry'";
	String query_nonExistingUserReferralEntry = "select * from registrationpage where status='fail' AND testingType='nonExistingUserReferralEntry'";
	String query_allValidInputs = "select * from registrationpage where status='fail' AND testingType='allValidInputs'";

	
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
	
//	database connection
	public List<String[]> dbdata(String query) throws SQLException {
		List<String[]> data = new ArrayList<>();

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			String name = rs.getString("name");
			String email = rs.getString("email");
			String phone = rs.getString("phone");
			String referenceId = rs.getString("referred id");
			String result = rs.getString("result");
			
			data.add(new String[] {name,email,phone,referenceId,result});
		}
		return data;
	}

	
//	assert methods
//	validate fields
	public void validateField() {
		// Assert.assertEquals(excepted error, actual error);
	}
	
	
//	clear
	public void clear() throws SQLException {
		con.close();
		driver.quit();
	}	
}
