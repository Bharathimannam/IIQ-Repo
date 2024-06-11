package com.eshiam.domain;

import java.io.Serializable;
import java.util.Objects;

public class Field implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3334134087387450021L;
	private String fieldName;
	private String fieldType;
	private Object fieldValue;
	public Field() {
		
	}
	
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public Object getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}
	@Override
	public int hashCode() {
		return Objects.hash(fieldName, fieldType, fieldValue);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Field other = (Field) obj;
		return Objects.equals(fieldName, other.fieldName) && Objects.equals(fieldType, other.fieldType)
				&& Objects.equals(fieldValue, other.fieldValue);
	}
	@Override
	public String toString() {
		return "Field [fieldName=" + fieldName + ", fieldType=" + fieldType + ", fieldValue=" + fieldValue + "]";
	}
	

}
