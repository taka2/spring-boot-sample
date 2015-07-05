package app.config;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class ConfigService {
	private static ConfigService theInstance;
	private PropertiesConfiguration prop;

	private ConfigService() {
		try {
			prop = new PropertiesConfiguration("config.properties");
		} catch(ConfigurationException e) {
			throw new RuntimeException(e);
		}
	}

	public synchronized static ConfigService getInstance() {
		if(theInstance == null) {
			theInstance = new ConfigService();
		}
		return theInstance;
	}

	public String getAAA() {
 		return prop.getString("aaa");
	}
}
