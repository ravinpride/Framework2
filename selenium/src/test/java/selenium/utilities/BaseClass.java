package selenium.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports extent;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupData() {
		
		Reporter.log("Starting datasetup", true);
		
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		ExtentHtmlReporter report = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/reports/report"+Helper.currentDate()+".html"));
		extent = new ExtentReports();
		extent.attachReporter(report);
		
		Reporter.log("Completed datasetup", true);
	}
	
	@BeforeClass
	public void startSetUp() {
		
		Reporter.log("Starting browser and application", true);
		
		Browserfactory bf = new Browserfactory();
		driver = bf.startApplication(driver, config.getUrl(), config.getBrowser());
		// System.out.println(driver.getTitle());
		
		Reporter.log("Started browser and application", true);
	}
	
	@AfterClass
	public void teardown() {
		
		Reporter.log("Closing the browser and application", true);
		
		Browserfactory bf = new Browserfactory();
		bf.quitBrowser(driver);
		
		Reporter.log("closed the browser and application", true);
	}
	
	@AfterMethod
	public void evidence(ITestResult result) throws IOException {
		
		Reporter.log("Test case scenario validated", true);
		
		if (result.getStatus()==ITestResult.FAILURE) {
			
			logger.fail("login failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		if (result.getStatus()==ITestResult.SUCCESS) {
			
			logger.pass("login passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		extent.flush();
		
		Reporter.log("report generated with screenshots attached", true);
		
	}
	
}
