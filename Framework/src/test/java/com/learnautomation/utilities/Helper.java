package com.learnautomation.utilities;

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

	public static String takeScreenshot(WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String scrnshot_path = System.getProperty("user.dir") + "\\Screenshots\\" + getCurrentDateTime() + "img.png";
		try {
			FileHandler.copy(src, new File(scrnshot_path));
			System.out.println("Screenshot captured");
		} catch (IOException e) {
			System.out.println("Unable to take screenshot because of" + e);
		}
		return scrnshot_path;
	}

	public static String getCurrentDateTime() {

		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");

		Date currentdate = new Date();

		return customformat.format(currentdate);

	}

}
