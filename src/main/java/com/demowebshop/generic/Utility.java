package com.demowebshop.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility implements FrameworkConstant{
	public static WebDriver driver=null;
	public static WaitNlp wait=new WaitNlp();
	public static Excel excelNlp=new Excel();
	
	public static String getPropertiesData(String key) {
		FileInputStream fis = null;
		try {
			fis=new FileInputStream(properties_file_path);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		Properties p=new Properties();
		try {
			p.load(fis);
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		try {
			fis.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return p.getProperty(key);
	}
	public static String getPhoto(String testName) {
		TakesScreenshot t=(TakesScreenshot) driver;
		File src=t.getScreenshotAs(OutputType.FILE);
		String dateTime=LocalDateTime.now().toString().replace(":", "_");
		String path="C:\\Users\\10820229\\eclipse-workspace\\DemoWebShop\\screenshot\\ "+dateTime+".png";
		File dest=new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
