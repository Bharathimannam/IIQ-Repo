package com.eshiam.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class WorkQueueEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2501788644124750L;
	private int id;
	private WorkQueue workQueueId;
	private String entityType;
	private String entityCode;
	private int entityId;
	private String entityStatus;
	private Date inDate;
	private Date outDate;
	private Date createdDate;
	private Date updatedDate; 
	private int createdBy;
	private int updatedBy;
	private String createdByUser;
	private String updatedByUser;
	
	public WorkQueueEntity() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public WorkQueue getWorkQueueId() {
		return workQueueId;
	}

	public void setWorkQueueId(WorkQueue workQueueId) {
		this.workQueueId = workQueueId;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public String getEntityCode() {
		return entityCode;
	}

	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}

	public int getEntityId() {
		return entityId;
	}

	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}

	public String getEntityStatus() {
		return entityStatus;
	}

	public void setEntityStatus(String entityStatus) {
		this.entityStatus = entityStatus;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
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
		return Objects.hash(createdBy, createdByUser, createdDate, entityCode, entityId, entityStatus, entityType, id,
				inDate, outDate, updatedBy, updatedByUser, updatedDate, workQueueId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkQueueEntity other = (WorkQueueEntity) obj;
		return createdBy == other.createdBy && Objects.equals(createdByUser, other.createdByUser)
				&& Objects.equals(createdDate, other.createdDate) && Objects.equals(entityCode, other.entityCode)
				&& entityId == other.entityId && Objects.equals(entityStatus, other.entityStatus)
				&& Objects.equals(entityType, other.entityType) && id == other.id
				&& Objects.equals(inDate, other.inDate) && Objects.equals(outDate, other.outDate)
				&& updatedBy == other.updatedBy && Objects.equals(updatedByUser, other.updatedByUser)
				&& Objects.equals(updatedDate, other.updatedDate) && Objects.equals(workQueueId, other.workQueueId);
	}

	@Override
	public String toString() {
		return "WorkQueueEntity [id=" + id + ", workQueueId=" + workQueueId + ", entityType=" + entityType
				+ ", entityCode=" + entityCode + ", entityId=" + entityId + ", entityStatus=" + entityStatus
				+ ", inDate=" + inDate + ", outDate=" + outDate + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", createdByUser="
				+ createdByUser + ", updatedByUser=" + updatedByUser + "]";
	}
}
