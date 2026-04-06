package com.demoshop.utils;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.demoshop.tests.BaseTest;
import org.openqa.selenium.WebDriver;

 // 1. IMPORT BaseTest here

public class Listeners extends BaseTest implements ITestListener {
    
    @Override
    public void onTestFailure(ITestResult result) {
        // 2. Access the driver from the test class that failed
        try {
            driver = (WebDriver) result.getTestClass().getRealClass()
                     .getField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Test Failed: " + result.getName());
        // Call your screenshot method here
        captureScreenshot(result.getName());
    }
}