package service.auth;

public class DummyAuthService implements AuthService {

	@Override
	public boolean authentication(String userid, String password) {
		// ユーザIDとパスワードが同じなら認証OKとする
		return userid.equals(password);
	}

}
