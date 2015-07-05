package app.model;

import java.util.Map;

public class Person {
	private Long id;
	private String name;
	private Long age;
	private String country;
	private String city;
	private boolean check;

	public Person() {
		
	}
	public Person(Long id, String name, Long age, String country, String city, Boolean check) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.country = country;
		this.city = city;
		this.check = check;
	}
	public Person(Map<String, Object> map) {
		this.id = (Long)map.get("id");
		this.name = (String)map.get("name");
		this.age = (Long)map.get("age");
		this.country = (String)map.get("country");
		this.city = (String)map.get("city");
		this.check = (Boolean)map.get("check");
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
		sb.append(":");
		sb.append(this.city);
		sb.append(":");
		sb.append(this.check);
		
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
}
