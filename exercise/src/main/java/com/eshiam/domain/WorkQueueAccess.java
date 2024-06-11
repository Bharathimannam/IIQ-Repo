package com.eshiam.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class WorkQueueAccess implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6160382086698803390L;
	private int id;
	private int workQueueId;
	//AccessType is the dropdown(User or Role) from the user interface
	private String accessType;
	private User user;
	private Role role;
	private Date createdDate;
	private Date updatedDate; 
	private int createdBy;
	private int updatedBy;
	private String createdByUser;
	private String updatedByUser;
	
	public WorkQueueAccess() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWorkQueueId() {
		return workQueueId;
	}

	public void setWorkQueueId(int workQueueId) {
		this.workQueueId = workQueueId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accessType, createdBy, createdByUser, createdDate, id, role, updatedBy, updatedByUser,
				updatedDate, user, workQueueId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkQueueAccess other = (WorkQueueAccess) obj;
		return Objects.equals(accessType, other.accessType) && createdBy == other.createdBy
				&& Objects.equals(createdByUser, other.createdByUser) && Objects.equals(createdDate, other.createdDate)
				&& id == other.id && Objects.equals(role, other.role) && updatedBy == other.updatedBy
				&& Objects.equals(updatedByUser, other.updatedByUser) && Objects.equals(updatedDate, other.updatedDate)
				&& Objects.equals(user, other.user) && workQueueId == other.workQueueId;
	}

	@Override
	public String toString() {
		return "WorkQueueAccess [id=" + id + ", workQueueId=" + workQueueId + ", user=" + user + ", role=" + role
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", createdBy=" + createdBy
				+ ", updatedBy=" + updatedBy + ", createdByUser=" + createdByUser + ", updatedByUser=" + updatedByUser
				+ ", accessType=" + accessType + "]";
	}
}
