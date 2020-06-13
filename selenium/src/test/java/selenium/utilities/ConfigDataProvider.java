package selenium.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	
	
	Properties pro;
	
	public ConfigDataProvider() {
		
		File src = new File("./config/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage()+"file not found");
		} 
		
	}
	
	public String getBrowser() {
		return pro.getProperty("browser");
	}

	public String getUrl() {
		return pro.getProperty("appurl");
	}
	
	public String getData(String keySearch) {
		return pro.getProperty(keySearch);
	}
}	
