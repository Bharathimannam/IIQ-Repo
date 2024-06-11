package com.eshiam.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class WorkQueue implements Serializable{
	private static final long serialVersionUID = 819044926493122283L;
	private int id;
	private String workQueueName;
	private Date createdDate;
	private Date updatedDate ;
	private int createdBy;
	private int updatedBy;
	private String createdByUser;
	private String updatedByUser;
	private LoginUser loginUser;
	private List<WorkQueueAccess> workQueueAccesses = new ArrayList<>();
	
	public WorkQueue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWorkQueueName() {
		return workQueueName;
	}

	public void setWorkQueueName(String workQueueName) {
		this.workQueueName = workQueueName;
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

	public LoginUser getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(LoginUser loginUser) {
		this.loginUser = loginUser;
	}

	public List<WorkQueueAccess> getWorkQueueAccesses() {
		return workQueueAccesses;
	}

	public void setWorkQueueAccesses(List<WorkQueueAccess> workQueueAccesses) {
		this.workQueueAccesses = workQueueAccesses;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdBy, createdByUser, createdDate, id, loginUser, updatedBy, updatedByUser, updatedDate,
				workQueueAccesses, workQueueName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkQueue other = (WorkQueue) obj;
		return createdBy == other.createdBy && Objects.equals(createdByUser, other.createdByUser)
				&& Objects.equals(createdDate, other.createdDate) && id == other.id
				&& Objects.equals(loginUser, other.loginUser) && updatedBy == other.updatedBy
				&& Objects.equals(updatedByUser, other.updatedByUser) && Objects.equals(updatedDate, other.updatedDate)
				&& Objects.equals(workQueueAccesses, other.workQueueAccesses)
				&& Objects.equals(workQueueName, other.workQueueName);
	}

	@Override
	public String toString() {
		return "WorkQueue [id=" + id + ", workQueueName=" + workQueueName + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy
				+ ", createdByUser=" + createdByUser + ", updatedByUser=" + updatedByUser + ", loginUser=" + loginUser
				+ ", workQueueAccesses=" + workQueueAccesses + "]";
	}
	
}

