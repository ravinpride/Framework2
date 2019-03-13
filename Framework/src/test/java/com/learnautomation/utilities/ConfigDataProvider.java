package com.learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;
	FileInputStream fis;
	public ConfigDataProvider() {
		
		
		try {
			File src = new File(".\\Config\\config.properties");
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find config file because "+e.getMessage());
		}
		pro=new Properties();
		try {
			pro.load(fis);
		} catch (IOException e) {
			System.out.println("Unable to load file because"+e.getMessage());
		}
		
		
	}
	
	public String getkeyValue(String key) {
		return pro.getProperty(key);
	}
	public String getBrowser() {
		return pro.getProperty("browser");
	}
	
	public String gettesturl() {
		return pro.getProperty("testurl");
	}
}
