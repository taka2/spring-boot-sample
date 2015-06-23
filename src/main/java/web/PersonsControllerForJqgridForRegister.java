package web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Person;

import org.springframework.boot.json.BasicJsonParser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import service.PersonService;

@RestController
@RequestMapping("/persons.jqgrid.register")
public class PersonsControllerForJqgridForRegister extends ApplicationController {
	@RequestMapping(method = RequestMethod.POST)
    public Map<String, String> registerPersons(@RequestBody String payload) {
    	System.out.println("register" + payload);
    	BasicJsonParser jsonParser = new BasicJsonParser();
    	List<Object> list = jsonParser.parseList(payload);
    	System.out.println(list);
    	System.out.println(list.size());
    	final int listSize = list.size(); 
    	for(int i=0; i<listSize; i++) {
    		Person person = new Person((Map)list.get(i));
    		PersonService.updatePerson(person);
    	}
    	
    	Map<String, String> result = new HashMap<String, String>();
    	result.put("status", "success");
    	return result;
    }
}