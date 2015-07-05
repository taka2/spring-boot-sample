package app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ApplicationController {
	@Autowired
    protected HttpSession session;

	protected boolean authenticated() {
		return session.getAttribute("userid") != null;
	}
}