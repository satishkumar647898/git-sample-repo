package com.demowebshop.testdev;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.demowebshop.generic.ExtentManager;
import com.demowebshop.generic.Utility;

public class BaseTest extends Utility{
	@BeforeMethod
	public void setUp() {
		String browserName=Utility.getPropertiesData("browserName");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			//ExtentManager.logStep("Browser Intilized successfully");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")){
			driver=new EdgeDriver();
		}
		else {
			Reporter.log("Please Enter Valid browser",true);
		}
//		switch (browserName) {
//		case "Chrome":
//			driver=new ChromeDriver();
//			break;
//		case "firefox":driver=new FirefoxDriver();
//		break;
//		case "edge":driver=new EdgeDriver();
//		break;
//		
//		default:Reporter.log("Please Enter Valid browser",true);
//			break;
//		}
		driver.manage().window().maximize();
		driver.get(Utility.getPropertiesData("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}
	@AfterMethod(alwaysRun = true)
	public void closeAllBrowser() {
		driver.quit();
	}

}
