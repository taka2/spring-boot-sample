package model;

import java.util.Map;

public class Country {
	private Long id;
	private String text;
	public Country() {
		
	}
	public Country(Long id, String text) {
		this.id = id;
		this.text = text;
	}
	public Country(Map<String, Object> map) {
		this.id = (Long)map.get("id");
		this.text = (String)map.get("text");
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
