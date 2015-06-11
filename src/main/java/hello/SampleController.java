package hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController {

    @RequestMapping("/helo")
    public String helo(Model model, @ModelAttribute("form") SampleForm form) {
    	String[] strArray = {"aaa", "bbb", "ccc"};
    	model.addAttribute("msg", "これはThymeleafを使ったサンプルです。");
    	model.addAttribute("strArray", strArray);
    	
    	List<Person> personList = new ArrayList<Person>();
    	personList.add(new Person(1, "hoge", 25));
    	personList.add(new Person(2, "moge", 35));
    	//model.addAttribute("personList", personList);
    	form.setPersonList(personList);

        return "helo";
    }

    @RequestMapping(value = "/personList", method = RequestMethod.POST)
    public String personList(@ModelAttribute("form") SampleForm form) {    	
    	for(Person person : form.getPersonList()) {
    		System.out.println(person.getName() + ":" + person.getAge());
    	}

        return "forward:/helo";
    }
}