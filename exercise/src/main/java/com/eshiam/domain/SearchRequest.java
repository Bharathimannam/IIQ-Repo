package com.eshiam.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class SearchRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3368694135559259288L;
	private String id;
	private String workQueueName;
	private String entityType;
	private int entityCode;
	private String entityStatus;
	private List<SearchCriteria> criterias= new ArrayList<>();
	private List<SearchResult> results = new ArrayList<>();
	private ShowColumn selectedColumn= new ShowColumn();
	//private List<ShowColumn> selectedColumn = new ArrayList<>();
	
	public SearchRequest() {
		
	}
	public SearchRequest(String entityType, List<SearchCriteria> criterias) {
		this.entityType = entityType;
		this.criterias = criterias;
	}
	public SearchRequest(String entityType, List<SearchCriteria> criterias, ShowColumn selectedColumn) {
		this.entityType = entityType;
		this.criterias = criterias;
		this.selectedColumn = selectedColumn;
	}
	
	public ShowColumn getSelectedColumn() {
		return selectedColumn;
	}
	public void setSelectedColumn(ShowColumn selectedColumn) {
		this.selectedColumn = selectedColumn;
	}
	public String getWorkQueueName() {
		return workQueueName;
	}
	public void setWorkQueueName(String workQueueName) {
		this.workQueueName = workQueueName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	public int getEntityCode() {
		return entityCode;
	}
	public void setEntityCode(int entityCode) {
		this.entityCode = entityCode;
	}
	public String getEntityStatus() {
		return entityStatus;
	}
	public void setEntityStatus(String entityStatus) {
		this.entityStatus = entityStatus;
	}
	public List<SearchCriteria> getCriterias() {
		return criterias;
	}
	public void setCriterias(List<SearchCriteria> criterias) {
		this.criterias = criterias;
	}
	public List<SearchResult> getResults() {
		return results;
	}
	public void setResults(List<SearchResult> results) {
		this.results = results;
	}
	@Override
	public String toString() {
		return "SearchRequest [id=" + id + ", workQueueName=" + workQueueName + ", entityType=" + entityType
				+ ", entityCode=" + entityCode + ", entityStatus=" + entityStatus + ", criterias=" + criterias
				+ ", results=" + results + ", selectedColumn=" + selectedColumn + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(criterias, entityCode, entityStatus, entityType, id, results, selectedColumn,
				workQueueName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SearchRequest other = (SearchRequest) obj;
		return Objects.equals(criterias, other.criterias) && entityCode == other.entityCode
				&& Objects.equals(entityStatus, other.entityStatus) && Objects.equals(entityType, other.entityType)
				&& Objects.equals(id, other.id) && Objects.equals(results, other.results)
				&& Objects.equals(selectedColumn, other.selectedColumn)
				&& Objects.equals(workQueueName, other.workQueueName);
	}
	
	
	

}
