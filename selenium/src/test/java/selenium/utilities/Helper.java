package selenium.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	
	
	public static String captureScreenshot(WebDriver driver) {
		
		
		String shotpath = System.getProperty("user.dir")+"/screenshots/screenshot__"+currentDate()+".png";
				
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src,new File(shotpath));
			System.out.println("screenshot captured");
		} catch (IOException e) {
			System.out.println(e.getMessage()+"unable to capture screenshot");
		}
		return shotpath;
	}
	
	public static String currentDate() {
		
		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss");
		
		Date currentdate = new Date();
		
		return customformat.format(currentdate);
		
	}
	
}
