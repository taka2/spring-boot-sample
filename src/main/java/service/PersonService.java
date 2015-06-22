package service;

import java.util.ArrayList;
import java.util.List;

import model.Person;

public class PersonService {
	private static List<Person> persons = new ArrayList<Person>();
	static {
    	persons.add(new Person(1L, "Taro", 25L, "Japan"));
    	persons.add(new Person(2L, "Bob", 35L, "US"));
    	persons.add(new Person(3L, "Hanako", 45L, "Japan"));
    	persons.add(new Person(4L, "Nancy", 55L, "US"));
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
	public static Person searchByRecid(Long id) {
		final int personsSize = persons.size();
		for(int i=0; i<personsSize; i++) {
			Person person = persons.get(i);
			if(person.getId() == id) {
				return person;
			}
		}
		
		return null;
	}
	public static void updatePerson(Person person) {
		final int personsSize = persons.size();
		for(int i=0; i<personsSize; i++) {
			if(persons.get(i).getId() == person.getId()) {
				persons.set(i, person);
			}
		}
	}
	public static void setPersons(List<Person> persons) {
		PersonService.persons = persons;
	}
}
