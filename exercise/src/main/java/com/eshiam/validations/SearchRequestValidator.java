package com.eshiam.validations;

import com.eshiam.domain.SearchRequest;
import com.eshiam.domain.ServiceDTO;

public interface SearchRequestValidator {
	public void validateSearchRequest(ServiceDTO<SearchRequest> dto); 
}
