package web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.PersonForW2UI;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import service.PersonServiceForW2UI;

@RestController
@RequestMapping("/persons.w2ui.json")
public class PersonsControllerForW2UI extends ApplicationController {
    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> getPersons() {
    	// Person一覧を取得
    	List<PersonForW2UI> persons = PersonServiceForW2UI.getPersons();
    	Map<String, Object> result = new HashMap<String, Object>();
    	result.put("total", persons.size());
    	result.put("records", persons);
    	return result;
    }
}