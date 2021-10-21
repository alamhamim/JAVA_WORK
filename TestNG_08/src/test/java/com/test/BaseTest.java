package com.test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.config.BrowserConfig;
import com.dataProvider.BrowserDataProvider;
import com.pages.LoginPage;
import com.util.SeleniumHelper;

public class BaseTest {
	WebDriver driver;
	LoginPage loginPage;
	BrowserDataProvider browserData;
	ExtentTest logger;
	ExtentReports reports;
	
	@BeforeClass
	public void getData() throws IOException {
		browserData = new BrowserDataProvider();
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File("/Users/ninja/eclipse-workspace/TestNG_08/Reports/log_"+SeleniumHelper.randomNumber()+".html"));
		reports = new ExtentReports();
		reports.attachReporter(extent);
		logger = reports.createTest("Login to orange");
		
		
	}
	
	@BeforeMethod
	public void setUpBrowser() {
		logger.info("chrome is running");
		driver = BrowserConfig.startApp(driver, browserData.getBrowserName(), browserData.getUrl());
	}
	
	@AfterMethod
	public void screenShot(ITestResult result) throws IOException {
		if (result.getStatus()==ITestResult.FAILURE) {
			
			logger.fail("Failed");
			SeleniumHelper.getSreenShot(driver);
			 
			
		}else {
			logger.pass("Test Passed");
		}
		
		reports.flush();
		
	}
	
	@AfterClass
	public void doneTesting() {
		BrowserConfig.tearDown(driver);
	}

}
