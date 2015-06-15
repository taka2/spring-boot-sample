package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.auth.AuthService;
import service.auth.AuthServiceFactory;
import config.AppConfig;

@Controller
@Component
@EnableConfigurationProperties(AppConfig.class)
public class UsersController extends ApplicationController {

	private AppConfig properties;

	@Autowired
	public UsersController(AppConfig properties) {
		this.properties = properties;
	}

    @RequestMapping("/")
    public String home(Model model, @ModelAttribute("form") UsersForm form) {
    	form.setUserid("");
    	form.setPassword("");
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, @ModelAttribute("form") UsersForm form) {
    	// 認証
    	AuthService authService = AuthServiceFactory.getInstance(properties.getAuthServiceClassname());
    	if(!authService.authentication(form.getUserid(), form.getPassword())) {
    		// 認証NG
    		model.addAttribute("errorMessage", "login failed");
    		return "index";
    	}
    	// 認証OK
    	session.setAttribute("userid", form.getUserid());
        return "redirect:/persons";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model, @ModelAttribute("form") UsersForm form) {
    	session.setAttribute("userid", null);
        return "redirect:/";
    }
}