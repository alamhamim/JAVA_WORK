package com.browserConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class BrowserConfig {

    /*By calling this method you will have to provide three parameters <drivers, browserName, And url>*/

    public static WebDriver startAPP(WebDriver driver, String browserName, String url) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/Drivers/geckodriver");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("opera")) {
            System.setProperty("webdriver.opera.driver", "src/main/resources/Drivers/operadriver");
            driver = new OperaDriver();
        } else if (browserName.equalsIgnoreCase("safari")) {
            System.setProperty("webdriver.safari.driver", "src/main/resources/Drivers/safaridriver");
            driver = new SafariDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "src/main/resources/Drivers/msedgedriver");
            driver = new EdgeDriver();
        } else {
            System.out.println(browserName+" "+"is not supported by the framework yet!!");
        }

        //
        //

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);

        //
        //

        return driver;

    }

    /*This method will close the browser or app*/

    public static void closeAPP(WebDriver driver) {
        driver.quit();
    }
}
