package model;

import java.util.Map;

public class Person {
	private Long id;
	private String name;
	private Long age;
	private String country;

	public Person() {
		
	}
	public Person(Long id, String name, Long age, String country) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.country = country;
	}
	public Person(Map<String, Object> map) {
		this.id = (Long)map.get("id");
		this.name = (String)map.get("name");
		this.age = (Long)map.get("age");
		this.country = (String)map.get("country");
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.id);
		sb.append(":");
		sb.append(this.name);
		sb.append(":");
		sb.append(this.age);
		sb.append(":");
		sb.append(this.country);
		
		return sb.toString();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
