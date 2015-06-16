package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import config.ConfigService;

@Controller
public class UsersController extends ApplicationController {

	@Autowired
	UsersValidator usersValidator;

	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(usersValidator);
    }

    @RequestMapping("/")
    public String home(Model model, @ModelAttribute("form") UsersForm form) {
    	form.setUserid("");
    	form.setPassword("");
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, @Validated @ModelAttribute("form") UsersForm form, BindingResult result) {
    	ConfigService.printAAA();
    	// 入力チェック
    	if(result.hasErrors()) {
    		return "index";
    	}

    	session.setAttribute("userid", form.getUserid());
        return "redirect:/persons";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model, @ModelAttribute("form") UsersForm form) {
    	session.setAttribute("userid", null);
        return "redirect:/";
    }
}