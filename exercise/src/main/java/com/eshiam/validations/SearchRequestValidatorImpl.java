package com.eshiam.validations;

import com.eshiam.domain.SearchCriteria;
import com.eshiam.domain.SearchRequest;
import com.eshiam.domain.SearchResult;
import com.eshiam.domain.ServiceDTO;

public class SearchRequestValidatorImpl implements SearchRequestValidator {

	@Override
	public void validateSearchRequest(ServiceDTO<SearchRequest> dto) {
		SearchRequest searchRequest = dto.getDataObject();
		if(searchRequest !=null) {
		validateWorkQueueName(dto);
		validateEntityType(dto);
		validateEntityCode(dto);
		validateEntityStatus(dto);
		validateCriterias(dto);
		}else {
			dto.addAppMessage("Search001", "please search one request", 5, "SearchRequest");
		}
		

	}

	private void validateCriterias(ServiceDTO<SearchRequest> dto) {
		SearchRequest searchRequest = dto.getDataObject();
		if (searchRequest != null && searchRequest.getCriterias() != null && searchRequest.getCriterias().size() > 0) {
			int index = 0;
			for (SearchCriteria searchCriteria : searchRequest.getCriterias()) {
				validateSearchCriteriaFieldName(dto, searchCriteria, index);
				validateSearchCriteriaCondition(dto, searchCriteria, index);
				validateSearchCriteriaValue(dto, searchCriteria, index);
				index++;
			}

		} else {
			// at least one search criteria is required
		}
	}

	private void validateSearchCriteriaValue(ServiceDTO<SearchRequest> dto, SearchCriteria searchCriteria, int index) {
		if(searchCriteria.getValue()==null) {
			dto.addAppMessage("Search012", "please enter search criteria value", 5, "value");
			
		}
	}

	private void validateSearchCriteriaCondition(ServiceDTO<SearchRequest> dto, SearchCriteria searchCriteria,
			int index) {
		if(searchCriteria.getCondition()==null) {
			dto.addAppMessage("Search011", "please enter search criteria condition", 5, "condition");
			
		}

	}

	private void validateSearchCriteriaFieldName(ServiceDTO<SearchRequest> dto, SearchCriteria searchCriteria,
			int index) {
		if(searchCriteria.getFieldName()==null) {
			dto.addAppMessage("Search009", "please enter search criteria fieldname", 5, "fieldName");
			
		}else if(searchCriteria.getFieldName().length()>15) {
			dto.addAppMessage("Search010", "please enter search criteria fieldname less than 15 characters", 5, "fieldName");
		}

	}

	private void validateEntityStatus(ServiceDTO<SearchRequest> dto) {
		SearchRequest searchRequest = dto.getDataObject();
		if(searchRequest.getEntityStatus()== null ) {
			dto.addAppMessage("Search007", "please enter Entity Status", 5, "entityStatus");
		} else if(searchRequest.getEntityStatus().length() > 20) {
			dto.addAppMessage("Search008", "please enter Entity Code less than 20 characters", 5, "entityStatus");
		}
	}

	private void validateEntityCode(ServiceDTO<SearchRequest> dto) {
		SearchRequest searchRequest = dto.getDataObject();
		if(searchRequest.getEntityCode()== 0 ) {
			dto.addAppMessage("Search005", "please enter Entity Code", 5, "entityCode");
		} else if(searchRequest.getEntityCode() > 10) {
			dto.addAppMessage("Search006", "please enter Entity Code less than 10 characters", 5, "entityCode");
		}
	}

	private void validateEntityType(ServiceDTO<SearchRequest> dto) {
		SearchRequest searchRequest = dto.getDataObject();
		if(searchRequest.getEntityType()== null || searchRequest.getWorkQueueName().trim().length()==0 ) {
			dto.addAppMessage("Search003", "please enter EntityType", 5, "EntityType");
		} else if(searchRequest.getEntityType().length()<15 ) {
			dto.addAppMessage("Search004", "please enter Valid  EntityType", 5, "EntityType");
		}
	}

	private void validateWorkQueueName(ServiceDTO<SearchRequest> dto) {
		SearchRequest searchRequest = dto.getDataObject();
		if(searchRequest.getWorkQueueName()== null || searchRequest.getWorkQueueName().trim().length()==0 ) {
			dto.addAppMessage("Search002", "please enter workqueueName", 5, "workQueueName");
		}
		}

	}


