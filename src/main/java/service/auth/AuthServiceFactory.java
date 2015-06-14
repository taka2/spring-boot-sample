package service.auth;

import java.io.IOException;

import config.ApplicationProperties;

public class AuthServiceFactory {
	public static synchronized AuthService getInstance() {
		try {
			String authServiceClassName = ApplicationProperties.getInstance().getProperty("authservice.classname");
			if("DummyAuthService".equals(authServiceClassName)) {
				return new DummyAuthService();
			} else {
				throw new RuntimeException("authServiceClass: " + authServiceClassName + " is not found.");
			}
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
}
