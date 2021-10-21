package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dataProvider.DataProvider;
import com.pages.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test(dataProvider = "loginData", dataProviderClass = DataProvider.class)
	public void loginTest(String username, String password) {
		loginPage = new LoginPage(driver);
		Assert.fail();
		loginPage.setLogin(username, password);
	}
	
	
	

}
