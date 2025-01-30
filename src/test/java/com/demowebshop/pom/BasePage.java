package com.demowebshop.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.testdev.BaseTest;

public class BasePage extends BaseTest{
	
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
