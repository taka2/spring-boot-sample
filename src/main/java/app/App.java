package app;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

import app.config.ConfigService;

@SpringBootApplication
public class App {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new Filter() {
            public void init(FilterConfig filterConfig) throws ServletException {
            }
            public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                                 FilterChain filterChain) throws IOException, ServletException {
                HttpServletRequest request = (HttpServletRequest) servletRequest;
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                String target = request.getRequestURI();

                if(target.startsWith("/css") || target.startsWith("/images") || target.startsWith("/js")) {
                  // スタティックコンテンツは認証なしでOK
                } else if(target.equals("/") || target.equals("/login") || target.equals("/logout")){
                  // ログイン画面とログイン認証リクエスト、ログアウトリクエストは認証なしでOK
                } else {
                  // セッションをチェック
                  HttpSession session = request.getSession();
                  if(session.getAttribute("userid") == null) {
                    // 認証なし
                    response.sendRedirect("/");
                    return;
                  }
                }
                filterChain.doFilter(servletRequest, servletResponse);
            }
            public void destroy() {
            }
        });
        return registrationBean;
    }

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				if("dev".equals(ConfigService.getInstance().getAAA())) {
					ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
					container.addErrorPages(error500Page);
				}
			}
		};
	}
}