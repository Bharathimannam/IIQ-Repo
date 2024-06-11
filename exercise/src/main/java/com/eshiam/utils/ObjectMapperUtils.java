package com.eshiam.utils;

import com.eshiam.domain.Field;
import com.eshiam.domain.SearchCriteria;
import com.eshiam.domain.SearchRequest;
import com.eshiam.domain.ShowColumn;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {
	public static void main(String[] args) throws Exception {
		SearchRequest searchRequest = new SearchRequest();
		/*
		 * searchRequest.setWorkQueueName("abc"); searchRequest.setEntityCode(1);
		 * searchRequest.setEntityStatus("success");
		 * searchRequest.setEntityType("role"); SearchCriteria criteria = new
		 * SearchCriteria(); criteria.setFieldName("first_name");
		 * criteria.setCondition("equals"); criteria.setValue("hemansh");
		 * criteria.setSearchRequestId(1); searchRequest.getCriterias().add(criteria);
		 * ShowColumn selectedColumn = new ShowColumn();
		 * //selectedColumn.setFields(List<Field>Field);
		 * selectedColumn.setOrderBy("last_name"); selectedColumn.setOrder("asc");
		 * selectedColumn.setPageSize(10); selectedColumn.setCurrentPage(1); Field field
		 * = new Field(); field.setFieldName("email"); field.setFieldType("String");
		 * field.setFieldValue("hemansh@gmail.com");
		 */
		
		
		String json = writeValueAsString(searchRequest);
		SearchRequest searchRequest1 = readValue(json,SearchRequest.class);
		System.out.println("parsing completed");
		
		
	}
		public static String writeValueAsString(Object object) throws Exception{
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(object);
			System.out.println(json);
			return json;
		}
		public static <T> T readValue(String json, Class<T> clazz) throws Exception{
			ObjectMapper objectMapper = new ObjectMapper();
			T object = objectMapper.readValue(json,clazz);
			System.out.println(object);
			return object;
		
	}

}
