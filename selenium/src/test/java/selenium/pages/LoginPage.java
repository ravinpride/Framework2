package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath=("//span[text()=\"Log In\"]")) WebElement loginbutton;
	@FindBy(name=("email")) WebElement uname;
	@FindBy(name=("password")) WebElement pass;
	@FindBy(xpath=("//div[text()=\"Login\"]")) WebElement loginToPage; 
	
	public void loginToCRM(String usernameofapplication, String passwordofapplication) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
		loginbutton.click();
		uname.sendKeys(usernameofapplication);
		pass.sendKeys(passwordofapplication);
		loginToPage.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
