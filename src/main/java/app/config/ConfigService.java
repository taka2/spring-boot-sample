package app.config;

import java.io.InputStream;
import java.util.Properties;

// config.properties
public class ConfigService {
	public static void printAAA() {
    	try {
    		InputStream is = ConfigService.class.getResourceAsStream("/config.properties");
    		Properties prop = new Properties();
    		prop.load(is);
    		System.out.println(prop.getProperty("aaa"));
    		is.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
	}
}
