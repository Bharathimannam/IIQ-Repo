package com.eshiam.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Role implements Serializable{
	
	private static final long serialVersionUID = 7179431656860498201L;
	private int id;
	private String roleName;
	private String roleDescription;

	private Date createdDate;
	private Date updatedDate;
	private int createdBy;
	private int updatedBy;
	private String createdByUser;
	private String updatedByUser;
	
	private List<RoleToAccess> accessList=new ArrayList<>();
	
	public Role() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
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

	public List<RoleToAccess> getAccessList() {
		return accessList;
	}

	public void setAccessList(List<RoleToAccess> accessList) {
		this.accessList = accessList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accessList, createdBy, createdByUser, createdDate, id, roleDescription, roleName, updatedBy,
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
		Role other = (Role) obj;
		return Objects.equals(accessList, other.accessList) && createdBy == other.createdBy
				&& Objects.equals(createdByUser, other.createdByUser) && Objects.equals(createdDate, other.createdDate)
				&& id == other.id && Objects.equals(roleDescription, other.roleDescription)
				&& Objects.equals(roleName, other.roleName) && updatedBy == other.updatedBy
				&& Objects.equals(updatedByUser, other.updatedByUser) && Objects.equals(updatedDate, other.updatedDate);
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", roleDescription=" + roleDescription + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy
				+ ", createdByUser=" + createdByUser + ", updatedByUser=" + updatedByUser + ", accessList=" + accessList
				+ "]";
	}
	


}
