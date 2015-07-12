package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PulldownValue {
	@Id
	@GeneratedValue
	private Long id;
	private String key;
	private String parentKey;
	private String value;
	private Integer sortOrder;
	public PulldownValue() {
	}
	public PulldownValue(String key, String parentKey, String value,
			Integer sortOrder) {
		this.key = key;
		this.parentKey = parentKey;
		this.value = value;
		this.sortOrder = sortOrder;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getParentKey() {
		return parentKey;
	}
	public void setParentKey(String parentKey) {
		this.parentKey = parentKey;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	@Override
	public String toString() {
		return "PulldownValues [id=" + id + ", key=" + key + ", parentKey=" + parentKey
				+ ", value=" + value + ", sortOrder=" + sortOrder + "]";
	}
}
