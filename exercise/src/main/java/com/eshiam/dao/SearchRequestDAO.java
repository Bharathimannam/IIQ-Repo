package com.eshiam.dao;

import com.eshiam.domain.SearchRequest;

public interface SearchRequestDAO {

public SearchRequest saveSearchRequest(SearchRequest searchRequest);

public SearchRequest deleteSearchRequest(SearchRequest searchRequest);

public SearchRequest retrieveSearchRequest(SearchRequest searchRequest);

}
