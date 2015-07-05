package app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;

import app.config.AppConfig;

@Controller
@EnableConfigurationProperties(AppConfig.class)
public class ApplicationController {
	@Autowired
    protected HttpSession session;
	
	@Autowired
	private AppConfig properties;

	protected boolean authenticated() {
		return session.getAttribute("userid") != null;
	}
}