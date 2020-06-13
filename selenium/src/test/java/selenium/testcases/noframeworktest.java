package selenium.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class noframeworktest {

	@Test
	public void loginApp() {
		
		
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://freecrm.co.in/");
		driver.findElement(By.xpath("//span[text()=\"Log In\"]")).click();
		driver.findElement(By.name("email")).sendKeys("ravi.115014@gmailcom");
		driver.findElement(By.name("password")).sendKeys("rk170592");
		driver.findElement(By.xpath("//div[text()=\"Login\"]"));
		
		driver.quit();
	}
	
}
