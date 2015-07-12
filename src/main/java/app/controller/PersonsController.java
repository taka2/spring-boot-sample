package app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.form.PersonsForm;
import app.jdbc.PulldownValuesRepository;
import app.model.Person;
import app.model.PulldownValue;
import app.service.PersonService;

@Controller
public class PersonsController extends ApplicationController {
    @Autowired
    PulldownValuesRepository repository;

    @RequestMapping("/persons")
    public String persons(Model model, @ModelAttribute("form") PersonsForm form) {
    	if(repository.count() == 0) {
    		// 初期データ投入
    		repository.save(new PulldownValue("country", null, "Japan", 1));
    		repository.save(new PulldownValue("country", null, "US", 2));
    		repository.save(new PulldownValue("city", "Japan", "Tokyo", 1));
    		repository.save(new PulldownValue("city", "Japan", "Osaka", 2));
    		repository.save(new PulldownValue("city", "US", "Newyork", 3));
    		repository.save(new PulldownValue("city", "US", "Cicago", 4));
    	}
    	String search = form.getSearch();
    	if(search != null) {
    		if("AAA".equals(search)) {
    			throw new RuntimeException("AAA");
    		}
	    	// Person一覧を取得
	    	List<Person> persons = PersonService.getPersons();
	    	// formにセット
	    	form.setPersons(persons);
    	}

    	// country一覧をセット
    	List<PulldownValue> countriesList = repository.findByKeyOrderBySortOrderAsc("country");
    	String[] countries = createPulldownList(countriesList);
    	model.addAttribute("countries", countries);
    	// city一覧をセット
    	List<PulldownValue> citiesList = repository.findByKeyOrderBySortOrderAsc("city");
    	Map<String, String[]> cities = createPulldownMap(citiesList);
    	model.addAttribute("cities", cities);
    	return "persons";
    }

    /**
     * プルダウン一覧から表示用のリストを作成
     * @param pulldownValuesList
     * @return
     */
    private String[] createPulldownList(List<PulldownValue> pulldownValuesList) {
    	Map<String, String[]> resultMap = createPulldownMap(pulldownValuesList);
    	return resultMap.get("dummy");
    }

    /**
     * プルダウン一覧から表示用のマップを作成
     * @param pulldownValuesList
     * @return
     */
    private Map<String, String[]> createPulldownMap(List<PulldownValue> pulldownValuesList) {
    	Map<String, String[]> result = new HashMap<>();

    	String parentKey = null;
    	List<String> valueList = new ArrayList<>();
    	for(PulldownValue value : pulldownValuesList) {
    		if(parentKey != null && !parentKey.equals(value.getParentKey())) {
    			result.put(parentKey, valueList.toArray(new String[0]));
    			valueList = new ArrayList<>();
    		}
    		parentKey = value.getParentKey();
    		valueList.add(value.getValue());
    	}
    	if(parentKey == null) {
    		parentKey = "dummy";
    	}
    	result.put(parentKey, valueList.toArray(new String[0]));

    	return result;
    }

    @RequestMapping(value = "/registerPersons", method = RequestMethod.POST)
    public String registerPersons(@ModelAttribute("form") PersonsForm form) {
    	// submitされた値を表示
    	for(Person person : form.getPersons()) {
    		System.out.println(person);
    	}
    	// Person一覧を更新
    	PersonService.setPersons(form.getPersons());

    	return "redirect:/persons?search=" + form.getSearch();
    }
}