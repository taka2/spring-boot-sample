package service;

import java.util.ArrayList;
import java.util.List;

import model.Country;
import model.Person;
import model.PersonForW2UI;

public class PersonService {
	private static List<Person> persons = new ArrayList<Person>();
	private static List<PersonForW2UI> personsForW2UI = new ArrayList<PersonForW2UI>();
	static {
    	persons.add(new Person(1, "Taro", 25, "Japan"));
    	persons.add(new Person(2, "Bob", 35, "US"));
    	persons.add(new Person(3, "Hanako", 45, "Japan"));
    	persons.add(new Person(4, "Nancy", 55, "US"));
    	personsForW2UI.add(new PersonForW2UI(1, "Taro", 25, new Country(1, "Japan")));
    	personsForW2UI.add(new PersonForW2UI(2, "Bob", 35, new Country(2, "US")));
    	personsForW2UI.add(new PersonForW2UI(3, "Hanako", 45, new Country(1, "Japan")));
    	personsForW2UI.add(new PersonForW2UI(4, "Nancy", 55, new Country(2, "US")));
	}

	public static List<Person> getPersons() {
    	return PersonService.persons;
	}
	public static List<PersonForW2UI> getPersonsForW2UI() {
    	return PersonService.personsForW2UI;
	}
	public static void setPersons(List<Person> persons) {
		PersonService.persons = persons;
	}
}
