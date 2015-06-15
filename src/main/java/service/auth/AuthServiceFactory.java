package service.auth;


public class AuthServiceFactory {
	public static synchronized AuthService getInstance(String authServiceClassname) {
		if("DummyAuthService".equals(authServiceClassname)) {
			return new DummyAuthService();
		} else if("LdapAuthService".equals(authServiceClassname)) {
			return new LdapAuthService();
		} else {
			throw new RuntimeException("authServiceClass: " + authServiceClassname + " is not found.");
		}
	}
}
