package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import config.AppConfig;
import config.AppConfigService;

@SpringBootApplication
public class App {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

        // AppConfigをAppConfigServiceに保持
        AppConfig appConfig = context.getBean(AppConfig.class);
        AppConfigService.getInstance(appConfig);
    }
}