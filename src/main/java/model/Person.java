package model;

public class Person {
	private Integer id;
	private String name;
	private Integer age;
	private String country;

	public Person() {
		
	}
	public Person(Integer id, String name, Integer age, String country) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.country = country;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
