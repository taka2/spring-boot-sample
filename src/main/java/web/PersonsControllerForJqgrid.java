package web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Person;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import service.PersonService;

@RestController
@RequestMapping("/persons.jqgrid.json")
public class PersonsControllerForJqgrid extends ApplicationController {
    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Object> getPersons() {
    	// 認証チェック
    	if(!authenticated()) {
    		return null;
    	}

    	// Person一覧を取得
    	List<Person> persons = PersonService.getPersons();
    	Map<String, Object> result = new HashMap<String, Object>();
    	result.put("total", 1);
    	result.put("page", 1);
    	result.put("records", persons.size());
    	result.put("rows", persons);
    	return result;
    }
    
    @RequestMapping(value = "/registerPersons2", method = RequestMethod.POST)
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

    	return "redirect:/persons?search=" + form.getSearch();
    }
}