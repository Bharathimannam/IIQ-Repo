

	package com.eshiam.utils;

	import com.eshiam.domain.Access;
	import com.fasterxml.jackson.databind.ObjectMapper;

	public class ObjectMapperUtils1 {
		public static void main(String[] args) throws Exception {
			Access access=new Access();
			access.setId(111);
			access.setAccessName("HR");
			access.setAccessDescription("This is HR Access");
			String json=writeValueAsString(access);
			readValue(json,Access.class);
			System.out.println("Parsing completed");
		}
			
			public static <T> String writeValueAsString(T object) throws Exception {
				ObjectMapper objectMapper=new ObjectMapper();
				String json=objectMapper.writeValueAsString(object);
				System.out.println(json);
				return json;
			}
			
			public static <T> T readValue(String json,Class<T> clazz) throws Exception {
				ObjectMapper objectMapper=new ObjectMapper();
				T object=objectMapper.readValue(json, clazz);
				System.out.println(object);
				return object;
			}

	}



