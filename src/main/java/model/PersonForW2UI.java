package model;

public class PersonForW2UI {
	private Integer recid;
	private String name;
	private Integer age;
	private Country country;

	public PersonForW2UI() {
		
	}
	public PersonForW2UI(Integer recid, String name, Integer age, Country country) {
		this.recid = recid;
		this.name = name;
		this.age = age;
		this.country = country;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.recid);
		sb.append(":");
		sb.append(this.name);
		sb.append(":");
		sb.append(this.age);
		sb.append(":");
		sb.append(this.country);
		
		return sb.toString();
	}
	public Integer getRecid() {
		return recid;
	}
	public void setRecid(Integer recid) {
		this.recid = recid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
}
