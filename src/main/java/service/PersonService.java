package service;

import java.util.ArrayList;
import java.util.List;

import model.Person;

public class PersonService {
	private static List<Person> persons = new ArrayList<Person>();
	static {
    	persons.add(new Person(1, "Taro", 25, "Japan"));
    	persons.add(new Person(2, "Bob", 35, "US"));
    	persons.add(new Person(3, "Hanako", 45, "Japan"));
    	persons.add(new Person(4, "Nancy", 55, "US"));
	}

	public static List<Person> getPersons() {
    	return PersonService.persons;
	}
	public static List<Person> getPersons(Person condition) {
		List<Person> resultList = new ArrayList<Person>();
    	for(Person p : PersonService.persons) {
    		if(condition.getId() != null && p.getId() != condition.getId()) {
    			continue;
    		}
    		if(condition.getName() != null && !p.getName().contains(condition.getName())) {
    			continue;
    		}
    		if(condition.getAge() != null && p.getAge() != condition.getAge()) {
    			continue;
    		}
    		if(condition.getCountry() != null && !p.getCountry().contains(condition.getCountry())) {
    			continue;
    		}
    		resultList.add(p);
    	}
    	
    	return resultList;
	}
	public static void setPersons(List<Person> persons) {
		PersonService.persons = persons;
	}
}
