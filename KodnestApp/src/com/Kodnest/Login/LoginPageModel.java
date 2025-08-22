package com.Kodnest.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageModel {
	private WebDriver driver;
	private Connection con;

	public LoginPageModel(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
//	Locator
	private By emailField = By.id("email-input");
	private By passwordField = By.id("password-input");
	private By loginButton = By.id("login-submit-button");
	private By ExceptedInvalidEmail = By.id("email-error");
	private By ExceptedInvalidPassword = By.id("password-error");
	private By incorrectCredentials = By.xpath("//div[text()='Incorrect Credentials']");
	private By userNotFound = By.xpath("//div[text()='User not found with this email address']");
	private By forgotPasswordLink = By.linkText("Forgot your password?");
	private By toggleButton = By.id("toggle-password-visibility");
	
//	Variable
	private String dburl = System.getenv("URL_DB");
	private String dbpassword = System.getenv("PASSWORD_DB");
	private String dbuser= System.getenv("USER_DB");
	
//	Query
	String queryInvalidEmailFormat = "select * from loginpage where status='fail' AND testingType='invalidemailformat'";
	String queryIncorrectCredentials = "select * from loginpage where status='fail' AND testingType='incorrectcredentials'";
	String queryUserNotFound = "select * from loginpage where status='fail' AND testingType='usernotfound'";
	String queryFieldEmpty = "select * from loginpage where status='fail' AND testingType='emailpasswordfieldblank'";
	String queryVaildLogin = "select * from loginpage where status='fail' AND testingType='validlogin'";

//	email field
	public void enterEmail(String Email) {
		WebElement email = driver.findElement(emailField);
		email.sendKeys(Email);
	}
	
//	password field
	public void enterPassword(String Password) {
		WebElement password = driver.findElement(passwordField);
		password.sendKeys(Password);
	}
	
//	login button
	public void loginButton() {
		WebElement login = driver.findElement(loginButton);
		login.click();
	}
	
//	assert check 
//	validate invalid email
	public String InvalidEmailExcepted() {
		return driver.findElement(ExceptedInvalidEmail).getText();
	}
	
//	validate incorrect credentials 
	public String IncorrectCredentials() {	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
		WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(incorrectCredentials));
		return text.getText();
	}
	
//	validate user not found
	public String UserNotFound() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
		WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(userNotFound));
		return text.getText();
	}
	
//	validate email required 
	public String EmailRequiredExpected() {
		return driver.findElement(ExceptedInvalidEmail).getText();
	}
	
//	validate password required
	public String PasswordRequiredExpected() {
		return driver.findElement(ExceptedInvalidPassword).getText();
	}
	
//	forgot password link
	public void ClickForgotPasswordLink() {
		driver.findElement(forgotPasswordLink).click();
	}
	
//	toggle feature
	public String passwordType() {
		return driver.findElement(passwordField).getDomAttribute("type");
	}
	
//	click toggle
	public void clickToggle() {
		driver.findElement(toggleButton).click();
	}
	
//	database connection
	public List<String[]> dbData(String query) throws SQLException {
		List<String[]> data = new ArrayList<>();
		
		con = DriverManager.getConnection(dburl,dbuser,dbpassword);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			String email = rs.getString("email");
			String password = rs.getString("password");
			String result = rs.getString("result");
			
			data.add(new String[]{email,password,result});
		}
		return data;
	}
	
//	clear
	public void clear() {
		driver.quit();
	}
}
