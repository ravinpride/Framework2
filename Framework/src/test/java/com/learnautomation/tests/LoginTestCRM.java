package com.learnautomation.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;

public class LoginTestCRM extends BaseClass{

		
	@Test(priority=1)
	public void loginAppTest() {
				
		logger=report.createTest("Login to CRM");
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting Application");
		lp.loginPage(excel.getStringData(0, 0, 0), excel.getStringData(0, 0, 1));
		logger.pass("Login success");

	}
	

}
