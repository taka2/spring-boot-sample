package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationProperties {
	private static ApplicationProperties theInstance;
	private Properties prop;

	private ApplicationProperties() throws IOException {
		InputStream is = null;
		try {
			is = this.getClass().getResourceAsStream("/application.properties");
			prop = new Properties();
			prop.load(is);
		} finally {
			if(is != null) {
				is.close();
			}
		}
	}
	
	public static synchronized ApplicationProperties getInstance() throws IOException {
		if(theInstance == null) {
			theInstance = new ApplicationProperties();
		}
		return theInstance;
	}
	
	public String getProperty(String key) {
		return prop.getProperty(key);
	}
}
