package service;

import java.util.ArrayList;
import java.util.List;

import model.Person;

public class PersonService {
	private static List<Person> persons = new ArrayList<Person>();
	static {
    	persons.add(new Person(1, "hoge", 25, "Japan"));
    	persons.add(new Person(2, "moge", 35, "US"));
	}

	public static List<Person> getPersons() {
    	return PersonService.persons;
	}
	
	public static void setPersons(List<Person> persons) {
		PersonService.persons = persons;
	}
}
