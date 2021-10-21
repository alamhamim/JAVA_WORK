package com.tests;

import com.dataProvider.ExeclSheetDataProvider;
import com.pages.LoginPage;
import jdk.internal.net.http.common.Log;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test(dataProvider = "loginData", dataProviderClass = ExeclSheetDataProvider.class)
    public void loginTest(String name, String pass) {
        loginPage = new LoginPage();
        loginPage.loginToApp(name, pass);

    }

    @Test
    public void testOne() {
        System.out.println("hello world");
    }



}
