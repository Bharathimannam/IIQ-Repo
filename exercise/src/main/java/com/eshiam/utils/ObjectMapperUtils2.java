package com.eshiam.utils;

import java.util.Date;

import com.eshiam.domain.Role;
import com.eshiam.domain.WorkQueue;
import com.eshiam.domain.WorkQueueAccess;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils2 {

	public static void main(String[] args) throws Exception {
		WorkQueue workQueue = new WorkQueue();
		workQueue.setWorkQueueName("IT Department");
		workQueue.setCreatedDate(new Date());
		workQueue.setUpdatedDate(new Date());
		workQueue.setCreatedBy(20);
		workQueue.setUpdatedBy(12);
		workQueue.setCreatedByUser("Shivani Kohade");
		workQueue.setUpdatedByUser("Mounika Arun");
		
		WorkQueueAccess workQueueAccess = new WorkQueueAccess();
		Role role = new Role();
		workQueueAccess.setAccessType("Role");
		//doubt how will I set the role id
		
		//workQueueAccess.setRole();
		workQueueAccess.setCreatedDate(new Date());
		workQueueAccess.setUpdatedDate(new Date());
		workQueueAccess.setCreatedBy(40);
		workQueueAccess.setUpdatedBy(42);
		//doubt can the values be same
		workQueueAccess.setCreatedByUser("Anant Sharma");
		workQueueAccess.setUpdatedByUser("Nia Meher");
		workQueue.getWorkQueueAccesses().add(workQueueAccess);
		
		String json = writeValueAsString(workQueue);
		WorkQueue workQueue2 = readValue(json, WorkQueue.class);
		System.out.println("Parsing Completed");
	}
	
	public static <T> String writeValueAsString(T object) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(object);
		System.out.println("json:" +json);
		return json;
	}
		
	public static <T> T readValue(String json, Class<T> clazz) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		T object = objectMapper.readValue(json,  clazz);
		System.out.println(object);
		return object;
	}

}
