package web;

import java.util.List;

import model.Person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.PersonService;

@Controller
public class PersonsController extends ApplicationController {
    @RequestMapping("/persons")
    public String persons(Model model, @ModelAttribute("form") PersonsForm form) {
    	// 認証チェック
    	if(!authenticated()) {
    		return "redirect:/";
    	}

    	// Person一覧を取得
    	List<Person> persons = PersonService.getPersons();
    	// formにセット
    	form.setPersons(persons);

    	// country一覧をセット
    	String[] countries = {"Japan", "US"};
    	model.addAttribute("countries", countries);
        return "persons";
    }

    @RequestMapping(value = "/registerPersons", method = RequestMethod.POST)
    public String registerPersons(@ModelAttribute("form") PersonsForm form) {
    	// 認証チェック
    	if(!authenticated()) {
    		return "redirect:/";
    	}

    	// submitされた値を表示
    	for(Person person : form.getPersons()) {
    		System.out.println(person);
    	}
    	// Person一覧を更新
    	PersonService.setPersons(form.getPersons());

        return "redirect:/persons";
    }
}