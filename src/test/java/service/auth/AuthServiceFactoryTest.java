package service.auth;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import mockit.Expectations;
import mockit.Mocked;

import org.junit.Test;

import app.config.AppConfigService;
import app.service.auth.AuthService;
import app.service.auth.AuthServiceFactory;

public class AuthServiceFactoryTest {
	@Test
	public void testGetInstanceForDummyAuthService(final @Mocked AppConfigService appConfigService) {
		// 準備
		new Expectations() {{
			appConfigService.getAuthServiceClassname(); result = "DummyAuthService";
		}};

		// 実行
		AuthService authService = AuthServiceFactory.getInstance();

		// 検証
		assertThat(authService.getClass().getName(), is("app.service.auth.DummyAuthService"));
	}
}
