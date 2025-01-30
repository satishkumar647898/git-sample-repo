package com.demowebshop.pom;

import org.openqa.selenium.WebDriver;

public class CommonPage {
	public Register register;
	
	public CommonPage(WebDriver driver) {
		register=new Register(driver);
	}

}
