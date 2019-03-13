package com.learnautomation.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class BrowserFactory {
	
	
	public static WebDriver startApp(WebDriver driver, String browserName, String url) {
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			}
		else if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver",".\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			}
		else if(browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver",".\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			}
		else 
			System.out.println("Browser enterd is invalid");
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		
		
		return driver;
	}
	public static void quitBrowser(WebDriver driver) {
		
		driver.close();
		
	}
}
