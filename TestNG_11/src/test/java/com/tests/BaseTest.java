package com.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.browserConfig.BrowserConfig;
import com.browserDataProvider.BrowserDataProvider;
import com.pages.LoginPage;
import com.util.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    WebDriver driver;
    ExtentTest logger; // will provide log to the report
    ExtentReports reports; //will help us generate the report
    LoginPage loginPage;
    BrowserDataProvider data;

    @BeforeClass
    public void getTestData() {
        data = new BrowserDataProvider();
        ExtentHtmlReporter extent = new ExtentHtmlReporter(new File("Test_Reports/testReport_" + SeleniumHelper.generateDate() + ".html"));
        reports = new ExtentReports();
        reports.attachReporter(extent);
        logger = reports.createTest("LoginTest");
    }

    @BeforeMethod
    public void browserSetup() {
        driver = BrowserConfig.startAPP(driver, data.getBrowserName(), data.getUrl());
    }

    @AfterMethod
    public void testResult(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.fail("Test is failed");
            SeleniumHelper.takeScreenShot(driver);

        } else {
            logger.pass("Test is passed");
        }

    }

    @AfterClass
    public void tearDown() {
        BrowserConfig.closeAPP(driver);
    }
}
