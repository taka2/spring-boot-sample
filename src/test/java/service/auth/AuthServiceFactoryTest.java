package service.auth;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import mockit.Expectations;
import mockit.Mocked;

import org.junit.Test;

import app.config.AppConfig;
import app.config.AppConfigService;
import app.service.auth.AuthService;
import app.service.auth.AuthServiceFactory;

public class AuthServiceFactoryTest {
	@Test
	public void testGetInstanceForDummyAuthService(final @Mocked AppConfig appConfig) {
		// 準備
		new Expectations() {{
			appConfig.getAuthServiceClassname(); result = "DummyAuthService";
		}};
		AppConfigService.getInstance(appConfig);

		// 実行
		AuthService authService = AuthServiceFactory.getInstance();

		// 検証
		assertThat(authService.getClass().getName(), is("app.service.auth.DummyAuthService"));
	}
}
