package com.Kodnest.ForgotPassword;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DatabaseUtils;

public class ForgotPasswordModel {

	private WebDriver driver;

	public ForgotPasswordModel(WebDriver driver) throws SQLException {
		super();
		this.driver = driver;
	}

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
	
//	clear
	public void clear() throws SQLException {
		DatabaseUtils.close();
		driver.quit();
	}
}
