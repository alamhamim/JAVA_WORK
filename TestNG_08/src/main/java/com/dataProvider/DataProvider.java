package com.dataProvider;

 

public class DataProvider {
	
	@org.testng.annotations.DataProvider(name = "loginData")
	public Object[][] userInfo() {
		Object[][] data = new Object[1][2];
		data[0][0] = "Admin";
		data[0][1] = "admin123";
		return data;
	}

}
