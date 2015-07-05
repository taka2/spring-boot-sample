package app.service.auth;

import app.config.AppConfigService;

public class AuthServiceFactory {
	public static synchronized AuthService getInstance() {
		String authServiceClassname = AppConfigService.getInstance().getAuthServiceClassname();
		if("DummyAuthService".equals(authServiceClassname)) {
			return new DummyAuthService();
		} else if("LdapAuthService".equals(authServiceClassname)) {
			return new LdapAuthService();
		} else {
			throw new RuntimeException("authServiceClass: " + authServiceClassname + " is not found.");
		}
	}
}
