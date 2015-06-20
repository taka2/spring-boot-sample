
package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Country;
import model.PersonForW2UI;

public class PersonServiceForW2UI {
	private static List<PersonForW2UI> persons = new ArrayList<PersonForW2UI>();
	static {
    	persons.add(new PersonForW2UI(1L, "Taro", 25L, new Country(1L, "Japan")));
    	persons.add(new PersonForW2UI(2L, "Bob", 35L, new Country(2L, "US")));
    	persons.add(new PersonForW2UI(3L, "Hanako", 45L, new Country(1L, "Japan")));
    	persons.add(new PersonForW2UI(4L, "Nancy", 55L, new Country(2L, "US")));
	}

	public static List<PersonForW2UI> getPersons() {
    	return PersonServiceForW2UI.persons;
	}
	public static void setPersons(List<PersonForW2UI> persons) {
		PersonServiceForW2UI.persons = persons;
	}
	public static PersonForW2UI searchByRecid(Long recid) {
		final int personsSize = persons.size();
		for(int i=0; i<personsSize; i++) {
			PersonForW2UI person = persons.get(i);
			if(person.getRecid() == recid) {
				return person;
			}
		}
		
		return null;
	}
	public static void updatePerson(Map<String, Object> changes) {
		Long recid = (Long)changes.get("recid");
		String name = (String)changes.get("name");
		Long age = (Long)changes.get("age");
		Country country = new Country((Map<String, Object>)changes.get("country"));
		PersonForW2UI person = PersonServiceForW2UI.searchByRecid(recid);
		if(person != null) {
			if(name != null) {
				person.setName(name);
			}
			if(age != null) {
				person.setAge(age);
			}
			if(country != null) {
				person.setCountry(country);
			}
		}
			
	}
}
