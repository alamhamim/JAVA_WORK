package com.dataProvider;

import java.io.IOException;
import java.util.Properties;

import com.util.SeleniumHelper;

public class BrowserDataProvider {
	Properties properties;
	
	
	public BrowserDataProvider() throws IOException {
		properties = SeleniumHelper.readProperties("Data/browserData.properties");
		
		
	}
	
	public String getBrowserName() {
		return properties.getProperty("browserName");
		
	}

	public String getUrl() {
		return properties.getProperty("url");
		
	}

}
