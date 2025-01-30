package com.demowebshop.generic;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;
	private static ExtentSparkReporter sparkReporter;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	public static void init() {
		sparkReporter = new ExtentSparkReporter("C:\\Users\\10820229\\eclipse-workspace\\DemoWebShop\\report\\extent.html");
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setDocumentTitle("Demo Web Shop Automation Report");
		sparkReporter.config().setReportName("Demo Web Shop Automation Test Report");
		sparkReporter.config().setTimeStampFormat("HH-MM-SS");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
	}
	static {
		init();
	}

	public static ExtentReports getExtent() {
		return extent;
	}

	public static ExtentTest createTest(String name) {
		ExtentTest extentTest = extent.createTest(name);
		test.set(extentTest);
		return extentTest;
	}

	public static ExtentTest getTest() {
		return test.get();
		
	}

	public static void logStep(String message) {
		 ExtentTest extentTest = getTest();
	        if (extentTest != null) {
	            extentTest.log(com.aventstack.extentreports.Status.PASS, message);
	        }
	        System.out.println(com.aventstack.extentreports.Status.PASS+" : "+message);
	}

	public static void flush() {
		if (extent != null) {
			extent.flush();
		}
	}
}
