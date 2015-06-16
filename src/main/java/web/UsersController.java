package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.auth.AuthService;
import service.auth.AuthServiceFactory;
import config.ConfigService;

@Controller
public class UsersController extends ApplicationController {

    @RequestMapping("/")
    public String home(Model model, @ModelAttribute("form") UsersForm form) {
    	form.setUserid("");
    	form.setPassword("");
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, @ModelAttribute("form") UsersForm form) {
    	ConfigService.printAAA();
    	// 認証
    	AuthService authService = AuthServiceFactory.getInstance();
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