package app.config;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class AppConfigService {
	private static AppConfigService theInstance;
	private PropertiesConfiguration prop;

	private AppConfigService() {
		try {
			prop = new PropertiesConfiguration("application.properties");
		} catch(ConfigurationException e) {
			throw new RuntimeException(e);
		}
	}

	public synchronized static AppConfigService getInstance() {
		if(theInstance == null) {
			theInstance = new AppConfigService();
		}
		return theInstance;
	}

	public String getAuthServiceClassname() {
 		return prop.getString("authservice.classname");
	}
}
