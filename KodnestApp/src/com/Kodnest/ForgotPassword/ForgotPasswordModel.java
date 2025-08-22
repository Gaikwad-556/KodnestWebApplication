package com.Kodnest.ForgotPassword;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordModel {

	private WebDriver driver;
	private Connection con;

	public ForgotPasswordModel(WebDriver driver) throws SQLException {
		super();
		this.driver = driver;
		this.con = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
	}
	
//	query
	String queryInvalidFormatEmail = "select * from passwordrecovery where status='fail' AND testingType='invalid email format'";
	String queryEmptyField = "select * from passwordrecovery where status='fail' AND testingType='field blank'";
	String queryinvalidEmail = "select * from passwordrecovery where status='fail' AND testingType='invalid user'";
	String queryValidEmail = "select * from passwordrecovery where status='pass' AND testingType='valid email'";
	
//	variable
	private String dbUrl = System.getenv("URL_DB");
	private String dbUser = System.getenv("USER_DB");
	private String dbPassword = System.getenv("PASSWORD_DB");

//	locators
	private By emailField = By.id("email-input");
	private By linkButton = By.id("send-reset-link-button");
	private By invalidFormat = By.id("email-error");
	private By invalidUser = By.xpath("//div[text()='User not found with this email address']");
	
//	email field
	public void enterEmailField(String text) {
		WebElement field = driver.findElement(emailField);
		field.sendKeys(text);
	}
	
//	reset link button
	public void sendLinkButton() {
		driver.findElement(linkButton).click();
	}
	
//	assert check
//	validate email field
	public String emailError() {
		return driver.findElement(invalidFormat).getText();
	}
	
//	validate invalid user field
	public String invalidUser() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(invalidUser));
		return text.getText();
	}
	
//	database connection
	public  List<String[]> dbdata(String query) throws SQLException {
		List<String[]> data = new ArrayList<>();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			String email = rs.getString("email");
			String result = rs.getString("expected result");
			
			data.add(new String[] {email,result});
		}
		return data;
	}
	
//	clear
	public void clear() throws SQLException {
		con.close();
		driver.quit();
	}
}
