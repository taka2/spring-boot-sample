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
public class PersonsController {

    @RequestMapping("/persons")
    public String helo(Model model, @ModelAttribute("form") PersonsForm form) {
    	// Person一覧を取得
    	List<Person> persons = PersonService.getPersons();
    	// formにセット
    	form.setPersons(persons);

        return "persons";
    }

    @RequestMapping(value = "/registerPersons", method = RequestMethod.POST)
    public String personList(@ModelAttribute("form") PersonsForm form) {
    	// submitされた値を表示
    	for(Person person : form.getPersons()) {
    		System.out.println(person.getId() + ":" + person.getName() + ":" + person.getAge());
    	}
    	// Person一覧を更新
    	PersonService.setPersons(form.getPersons());

        return "redirect:/persons";
    }
}