package service.auth;

public class LdapAuthService implements AuthService {

	@Override
	public boolean authentication(String userid, String password) {
		return true;
	}

}
