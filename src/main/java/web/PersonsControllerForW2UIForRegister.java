package web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.json.BasicJsonParser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import service.PersonServiceForW2UI;

@RestController
@RequestMapping("/persons.w2ui.register")
public class PersonsControllerForW2UIForRegister extends ApplicationController {
	@RequestMapping(method = RequestMethod.POST)
    public Map<String, String> registerPersons(@RequestBody String payload) {
    	System.out.println("register" + payload);
    	BasicJsonParser jsonParser = new BasicJsonParser();
    	Map<String, Object> map = jsonParser.parseMap(payload);
    	System.out.println(map);
    	List<Map> changes = (List<Map>)map.get("changes");
    	for(int i=0; i<changes.size(); i++) {
    		PersonServiceForW2UI.updatePerson(changes.get(i));
    	}
    	
    	Map<String, String> result = new HashMap<String, String>();
    	result.put("status", "success");
    	return result;
    }
}