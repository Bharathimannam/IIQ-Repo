package com.eshiam.service;

import com.eshiam.domain.SearchRequest;
import com.eshiam.domain.ServiceDTO;


public interface SearchRequestService {
	public ServiceDTO<SearchRequest> save(SearchRequest searchRequest);
	
	public ServiceDTO<SearchRequest> retrieve(SearchRequest searchRequest);
	
	public ServiceDTO<SearchRequest> delete(SearchRequest searchRequest);

}
