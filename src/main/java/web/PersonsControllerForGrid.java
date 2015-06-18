package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonsControllerForGrid extends ApplicationController {
    @RequestMapping("/persons_jqgrid")
    public String personsJqgrid(Model model, @ModelAttribute("form") PersonsForm form) {
    	// 認証チェック
    	if(!authenticated()) {
    		return "redirect:/";
    	}

        return "persons_jqgrid";
    }

    @RequestMapping("/persons_w2ui")
    public String personsDatatables(Model model, @ModelAttribute("form") PersonsForm form) {
    	// 認証チェック
    	if(!authenticated()) {
    		return "redirect:/";
    	}

        return "persons_w2ui";
    }
}