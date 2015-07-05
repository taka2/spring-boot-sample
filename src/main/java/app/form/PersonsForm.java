package app.form;

import java.util.List;

import app.model.Person;

public class PersonsForm {
	private String search;
	private List<Person> persons;

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
}
