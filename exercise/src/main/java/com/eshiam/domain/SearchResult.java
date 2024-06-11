package com.eshiam.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1674147390836841964L;
	private List<Field> fields = new ArrayList<>();
	
	public SearchResult() {
		
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fields);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SearchResult other = (SearchResult) obj;
		return Objects.equals(fields, other.fields);
	}

	@Override
	public String toString() {
		return "SearchResult [fields=" + fields + "]";
	}
	

}
