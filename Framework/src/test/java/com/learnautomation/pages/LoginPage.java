package com.learnautomation.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;

	public LoginPage() {
		super();
	 }

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	@FindBy(xpath="//a[contains(@href,'https://ui.')]") WebElement signinlink;
	@FindBy(name="email") WebElement EMailAddress;
	@FindBy(name="password") WebElement Password;
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']") WebElement Login;
	
	public void loginPage(String username, String password) {
		
		for (int i = 0; i < 3; i++) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.elementToBeClickable(signinlink));
				signinlink.click();
				break;
			} catch (TimeoutException e) {
				System.out.println(e);
				
			} 
			catch (Exception e) {
				System.out.println(e);
				
			} 
		}
		EMailAddress.sendKeys(username);
		Password.sendKeys(password);
		Login.click();
		
	}
	
	
	
}
