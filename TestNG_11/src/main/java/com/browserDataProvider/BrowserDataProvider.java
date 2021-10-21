package com.browserDataProvider;

import com.util.SeleniumHelper;

import java.io.IOException;
import java.util.Properties;

public class BrowserDataProvider {
    Properties properties;

    public BrowserDataProvider() {
        try {
            properties = SeleniumHelper.readProperties("src/main/resources/browserData/browserData.properties");
        } catch (IOException e) {
            /*making it easy to read the error in the console*/
            System.out.println("Can not get the browserData.properties << file");
        }
    }

    /*this method will return the browser name from the property file*/
    public String getBrowserName() {
        return properties.getProperty("browserName");
    }

    /*This method will return the url from the property file*/
    public String getUrl() {
        return properties.getProperty("url");
    }

}
