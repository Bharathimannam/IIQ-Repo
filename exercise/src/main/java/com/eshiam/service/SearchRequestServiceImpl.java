package com.eshiam.service;

import com.eshiam.dao.SearchRequestDAO;
import com.eshiam.dao.SearchRequestDAOImpl;
import com.eshiam.domain.SearchRequest;
import com.eshiam.domain.ServiceDTO;
import com.eshiam.validations.SearchRequestValidator;
import com.eshiam.validations.SearchRequestValidatorImpl;

public class SearchRequestServiceImpl implements SearchRequestService{
	private SearchRequestValidator validator = new SearchRequestValidatorImpl();
	private SearchRequestDAO dao = new SearchRequestDAOImpl();

	@Override
	public ServiceDTO<SearchRequest> save(SearchRequest searchRequest) {
	//	ServiceDTO<SearchRequest> dto = new ServiceDTO<>();
	//	dto.setDataObject(searchRequest);
		//validator.validateSearchRequest(dto);
		//if(dto.getSeverity()<5) {
		//SearchRequest dbsearchRequest = 	dao.saveSearchRequest(searchRequest);
		//dto.setDataObject(dbsearchRequest);
		//}
		
		return null;
	}

	@Override
	public ServiceDTO<SearchRequest> retrieve(SearchRequest searchRequest) {
		ServiceDTO<SearchRequest> dto = new ServiceDTO<>();
		dto.setDataObject(searchRequest);
		if(searchRequest !=null) {
		SearchRequest dbsearchRequest = 	dao.retrieveSearchRequest(searchRequest);
		dto.setDataObject(dbsearchRequest);
		}
		
		return dto;
	}

	@Override
	public ServiceDTO<SearchRequest> delete(SearchRequest searchRequest) {
		ServiceDTO<SearchRequest> dto = new ServiceDTO<>();
		dto.setDataObject(searchRequest);
		if(searchRequest !=null) {
		SearchRequest dbsearchRequest = 	dao.deleteSearchRequest(searchRequest);
		dto.setDataObject(dbsearchRequest);
		}
		
		return dto;
	}

	
}
