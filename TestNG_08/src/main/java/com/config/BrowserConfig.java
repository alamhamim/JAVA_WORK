package com.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

public class BrowserConfig {

	public static WebDriver startApp(WebDriver driver, String browserName, String url) {
		 
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
			driver = new ChromeDriver();
			Reporter.log("chrome is runnig");
			System.out.println("Chrome is runnig");

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver");
			driver = new FirefoxDriver();
			Reporter.log("Firefox is running");
			System.out.println("Firefox is runnig");

		} else if (browserName.equalsIgnoreCase("opera")) {
			System.setProperty("webdriver.opera.driver", "Drivers/operadriver");
			driver = new OperaDriver();
			Reporter.log("Opera is runnig");
			System.out.println("Opera is runnig");

		} else if (browserName.equalsIgnoreCase("safari")) {
			System.setProperty("webdriver.safari.driver", "Drivers/safarridriver");
			driver = new SafariDriver();
			Reporter.log("Safari is runnig");
			System.out.println("Safari is runnig");
			
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "Drivers/msedgedriver");
			driver = new EdgeDriver();
			Reporter.log("Edge is running");
			System.out.println("Edge is running");

		} else {
			System.out.println(browserName+" "+"is not supported by this framework!!!");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		
		return driver;
		
	}
	
	
	
	public static void tearDown(WebDriver driver) {
		driver.quit();
		
	}
	
	
	
	
	
	
	
	

}
