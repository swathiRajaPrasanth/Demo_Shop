package com.demoshop.tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.demoshop.utils.ExtentManager;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    protected static ExtentReports extent = ExtentManager.getInstance();
    protected ExtentTest test;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser, Method method) {
        test = extent.createTest(method.getName());
        switch (browser.toLowerCase()) {
            case "chrome":
                driver =new ChromeDriver();
                test.info("Browser started: " + browser);
                break;
            case "firefox":
                driver=new FirefoxDriver();
                test.info("Browser started: " + browser);
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://demowebshop.tricentis.com/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test Failed: " + result.getThrowable());
            // Optional: add screenshot logic here
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        }
        if (driver != null) {
            driver.quit();
        }
    }

    public String captureScreenshot(String testName) {
    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    String path = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
    try {
        FileUtils.copyFile(src, new File(path));
    } catch (IOException e) {
        e.printStackTrace();
    }
    return path;
}
@AfterSuite
    public void flushReport() {
        // This line is CRITICAL - it actually writes the data to the file
        extent.flush();
    }
}
