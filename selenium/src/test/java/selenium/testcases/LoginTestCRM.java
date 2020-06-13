package selenium.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import selenium.pages.LoginPage;
import selenium.utilities.BaseClass;

public class LoginTestCRM extends BaseClass{

	
	

	@Test(priority = 1)
	public void loginApp() {
		
		Reporter.log("starting validation", true);
		
		logger = extent.createTest("Login to CRM");
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		logger.info("starting application....");
		
		loginpage.loginToCRM(excel.getStringValue("Login", 0, 0),excel.getStringValue("Login", 0, 1));
		logger.pass("logged in successfully");
		
		Reporter.log("validation is complete", true);

	}
	
		
}
