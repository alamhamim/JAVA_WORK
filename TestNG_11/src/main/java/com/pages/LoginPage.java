package com.pages;

import com.util.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class LoginPage {
    Properties properties;
    WebDriver driver;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    WebElement userName;

    @FindBy(name = "passWord")
    WebElement passWord;

    @FindBy(id = "loginButton")
    WebElement loginButton;

    /*In this test case first we are passing the username and the password
    * Then tyring to login to the app*/

    public void loginToApp(String username, String password) {
        try {
            SeleniumHelper.type(userName, username);
            SeleniumHelper.type(passWord, password);
            SeleniumHelper.waitForElement(loginButton, driver, 10); //this will wait till 10 for the element to be ready
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
