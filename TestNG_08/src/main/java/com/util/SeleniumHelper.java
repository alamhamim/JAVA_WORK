package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelper {

	public static Properties readProperties(String path) throws IOException {
		FileInputStream file = new FileInputStream(new File(path));
		Properties properties = new Properties();
		properties.load(file);
		return properties;

	}

	public static void type(WebElement element, String givenText) {
		element.sendKeys(givenText);

	}

	public static WebElement waitForElement(WebDriver driver, WebElement element, int second) {
		WebDriverWait wait = new WebDriverWait(driver, second);
		WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(element));
		return element2;
	}

	public static String getSreenShot(WebDriver driver) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Screenshots/Orange_" + getcurrentdatetime() + ".png";

		File destination = new File(path);

		try {

			FileHandler.copy(source, destination);
		}

		catch (IOException e) {

			System.out.println("Capture Failed" + e.getMessage());

		}
		return path;

	}

	public static String getcurrentdatetime() {

		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");

		Date currentdate = new Date();
		return customformat.format(currentdate);
	}

	public static int randomNumber() {
		int x = (int) Math.random();
		return x;
	}
}
