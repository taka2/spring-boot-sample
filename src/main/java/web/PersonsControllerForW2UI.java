package web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Person;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import service.PersonService;

@RestController
@RequestMapping("/persons.w2ui.json")
public class PersonsControllerForW2UI extends ApplicationController {
    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Object> getPersons() {
    	// Person一覧を取得
    	List<Person> persons = PersonService.getPersons();
    	Map<String, Object> result = new HashMap<String, Object>();
    	result.put("total", persons.size());
    	result.put("records", persons);
    	return result;
    }
}