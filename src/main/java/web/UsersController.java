package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    	// 認証
    	session.setAttribute("userid", form.getUserid());
        return "redirect:/persons";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model, @ModelAttribute("form") UsersForm form) {
    	session.setAttribute("userid", null);
        return "redirect:/";
    }
}