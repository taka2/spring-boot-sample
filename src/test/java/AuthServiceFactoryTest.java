import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import service.auth.AuthService;
import service.auth.AuthServiceFactory;

public class AuthServiceFactoryTest {
	@Test
	public void testGetInstance() {
		AuthService authService = AuthServiceFactory.getInstance("DummyAuthService");
		assertThat(authService.getClass().getName(), is("service.auth.DummyAuthService"));
	}
}
