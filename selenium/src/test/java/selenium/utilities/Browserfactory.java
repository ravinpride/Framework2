package selenium.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browserfactory {

	
	public WebDriver startApplication(WebDriver driver, String appurl, String browser) {
		
		if(browser.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "./drivers/chromedriver.exe");
			driver = new InternetExplorerDriver();
		}
		
		else
			System.out.println("invalid browser");
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(appurl);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
		
	}
	
	public void quitBrowser(WebDriver driver) {
		driver.quit();
	}
	
}
