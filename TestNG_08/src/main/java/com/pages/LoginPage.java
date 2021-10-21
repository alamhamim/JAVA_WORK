package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.SeleniumHelper;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//input[@id='txtUsername']")
	WebElement userName;
	
	@FindBy(name = "txtPassword")
	WebElement passWord;
	
	@FindBy(name = "Submit")
	WebElement login;
	
	public void setLogin(String username, String password) {
		SeleniumHelper.type(userName, username);
		SeleniumHelper.type(passWord, password);
		SeleniumHelper.waitForElement(driver, login, 10);
	}
	
	
}
