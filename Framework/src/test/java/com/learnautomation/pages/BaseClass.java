package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ConfigDataProvider;
import com.learnautomation.utilities.ExcelDataProvider;
import com.learnautomation.utilities.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider con;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() {
		excel = new ExcelDataProvider();
		con = new ConfigDataProvider();
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"\\Reports\\FreeCRM.html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@Parameters({"browser","baseLink"})
	@BeforeClass
	public void setup(String browser, String baseLink) {
		driver = BrowserFactory.startApp(driver, browser, baseLink);

	}
	
	@AfterMethod
	public void teardownmethod(ITestResult result) throws IOException {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.takeScreenshot(driver)).build());
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.takeScreenshot(driver)).build());
		}
		report.flush();
	}

	@AfterClass
	public void teardown() {
		BrowserFactory.quitBrowser(driver);
		
	}
}
