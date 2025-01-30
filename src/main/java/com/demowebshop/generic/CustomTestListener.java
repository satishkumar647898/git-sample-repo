package com.demowebshop.generic;

import com.aventstack.extentreports.Status;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomTestListener implements ITestListener, ISuiteListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentManager.createTest(result.getMethod().getMethodName());
        ExtentManager.getTest().log(Status.INFO, "Test started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getTest().log(Status.PASS, "Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
    		Utility.getPhoto("satish");
    		ExtentManager.getTest().log(Status.FAIL, "Test failed: " + result.getMethod().getMethodName());
        // Capture and attach screenshot
        String screenshotPath = Utility.getPhoto(result.getMethod().getMethodName());
        try {
            ExtentManager.getTest().addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentManager.getTest().log(Status.SKIP, "Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test suite started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test suite finished: " + context.getName());
        ExtentManager.flush();
    }

    @Override
    public void onStart(ISuite suite) {
        System.out.println("Suite started: " + suite.getName());
        ExtentManager.init();
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Suite finished: " + suite.getName());
        ExtentManager.flush();
    }
}