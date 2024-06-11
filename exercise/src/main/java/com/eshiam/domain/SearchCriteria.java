package com.eshiam.domain;

import java.io.Serializable;
import java.util.Objects;

public class SearchCriteria implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7473667341641932295L;
	private int id;
	private int searchRequestId;
	private String fieldName;
	private String condition;
	private Object value;
	
	public SearchCriteria() {
		
	}
	public SearchCriteria(String fieldName,String condition,Object value) {
		this.fieldName= fieldName;
		this.condition = condition;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSearchRequestId() {
		return searchRequestId;
	}

	public void setSearchRequestId(int searchRequestId) {
		this.searchRequestId = searchRequestId;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(condition, fieldName, id, searchRequestId, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SearchCriteria other = (SearchCriteria) obj;
		return Objects.equals(condition, other.condition) && Objects.equals(fieldName, other.fieldName)
				&& id == other.id && searchRequestId == other.searchRequestId && Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "SearchCriteria [id=" + id + ", searchRequestId=" + searchRequestId + ", fieldName=" + fieldName
				+ ", condition=" + condition + ", value=" + value + "]";
	}
	

}
