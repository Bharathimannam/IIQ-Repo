package com.eshiam.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShowColumn implements Serializable{
	private List<Field> fields = new ArrayList<>();
	private String orderBy;
	private String order;
	private int pageSize =10;
	private int currentPage=1;
	
	public ShowColumn() {
		
	}
	public ShowColumn(List<Field> fields,String orderBy ) {
		this.fields = fields;
		this.orderBy = orderBy;
		
	}
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	@Override
	public String toString() {
		return "ShowColumn [fields=" + fields + ", orderBy=" + orderBy + ", order=" + order + ", pageSize=" + pageSize
				+ ", currentPage=" + currentPage + ", getFields()=" + getFields() + ", getOrderBy()=" + getOrderBy()
				+ ", getOrder()=" + getOrder() + ", getPageSize()=" + getPageSize() + ", getCurrentPage()="
				+ getCurrentPage() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(currentPage, fields, order, orderBy, pageSize);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShowColumn other = (ShowColumn) obj;
		return currentPage == other.currentPage && Objects.equals(fields, other.fields)
				&& Objects.equals(order, other.order) && Objects.equals(orderBy, other.orderBy)
				&& pageSize == other.pageSize;
	}

}
