package model;

public class PersonForW2UI {
	private Long recid;
	private String name;
	private Long age;
	private Country country;

	public PersonForW2UI() {
		
	}
	public PersonForW2UI(Long recid, String name, Long age, Country country) {
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
	public Long getRecid() {
		return recid;
	}
	public void setRecid(Long recid) {
		this.recid = recid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
}
