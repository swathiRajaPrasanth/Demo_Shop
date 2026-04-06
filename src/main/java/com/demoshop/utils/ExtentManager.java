package com.demoshop.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            // Define the report location
            ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
            
            // Configuration
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("DemoShop Automation Report");
            spark.config().setReportName("Regression Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Tester", "Swathi");
            extent.setSystemInfo("OS", "MacOS Sequoia");
        }
        return extent;
    }
}