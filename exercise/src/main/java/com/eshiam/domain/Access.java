package com.eshiam.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Access implements Serializable{
	private static final long serialVersionUID = -5771812041512475560L;
	private int id;
	private String accessName;
	private String accessDescription;
	private Date createdDate;
	private Date updatedDate ;
	private int createdBy;
	private int updatedBy;
	private String createdByUser;
	private String updatedByUser;
	private String action;
	

	public Access() {
		 
	 }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccessName() {
		return accessName;
	}

	public void setAccessName(String accessName) {
		this.accessName = accessName;
	}

	public String getAccessDescription() {
		return accessDescription;
	}

	public void setAccessDescription(String accessDescription) {
		this.accessDescription = accessDescription;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}

	public String getUpdatedByUser() {
		return updatedByUser;
	}

	public void setUpdatedByUser(String updatedByUser) {
		this.updatedByUser = updatedByUser;
	}
	 public String getAction() {
			return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public int hashCode() {
		return Objects.hash(action, accessDescription, accessName, createdBy, createdByUser, createdDate, id, updatedBy,
				updatedByUser, updatedDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Access other = (Access) obj;
		return Objects.equals(action, other.action) && Objects.equals(accessDescription, other.accessDescription)
				&& Objects.equals(accessName, other.accessName) && createdBy == other.createdBy
				&& Objects.equals(createdByUser, other.createdByUser) && Objects.equals(createdDate, other.createdDate)
				&& id == other.id && updatedBy == other.updatedBy && Objects.equals(updatedByUser, other.updatedByUser)
				&& Objects.equals(updatedDate, other.updatedDate);
	}

	@Override
	public String toString() {
		return "Access [id=" + id + ", accessName=" + accessName + ", accessDescription=" + accessDescription
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", createdBy=" + createdBy
				+ ", updatedBy=" + updatedBy + ", createdByUser=" + createdByUser + ", updatedByUser=" + updatedByUser
				+ ", action=" + action + "]";
	}
	 


}
