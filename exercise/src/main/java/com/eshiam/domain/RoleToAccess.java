package com.eshiam.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class RoleToAccess implements Serializable{
	
	private static final long serialVersionUID = -1341917809445921092L;
	private int id;
	private int roleId;
	private String accessName;
	private Date createdDate;
	private Date updatedDate;
	private int createdBy;
	private int updatedBy;
	private String createdByUser;
	private String updatedByUser;
	
	public RoleToAccess() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	

	public String getAccessName() {
		return accessName;
	}

	public void setAccessName(String accessName) {
		this.accessName = accessName;
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
	@Override
	public int hashCode() {
		return Objects.hash(accessName, createdBy, createdByUser, createdDate, id, roleId, updatedBy, updatedByUser,
				updatedDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleToAccess other = (RoleToAccess) obj;
		return Objects.equals(accessName, other.accessName) && createdBy == other.createdBy
				&& Objects.equals(createdByUser, other.createdByUser) && Objects.equals(createdDate, other.createdDate)
				&& id == other.id && roleId == other.roleId && updatedBy == other.updatedBy
				&& Objects.equals(updatedByUser, other.updatedByUser) && Objects.equals(updatedDate, other.updatedDate);
	}
	@Override
	public String toString() {
		return "RoleToAccess [id=" + id + ", roleId=" + roleId + ", accessName=" + accessName + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy
				+ ", createdByUser=" + createdByUser + ", updatedByUser=" + updatedByUser + "]";
	}

}

