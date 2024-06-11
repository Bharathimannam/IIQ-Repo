package com.eshiam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eshiam.domain.Field;
import com.eshiam.domain.SearchCriteria;
import com.eshiam.domain.SearchRequest;
import com.eshiam.domain.SearchResult;
import com.eshiam.domain.ShowColumn;

public class SearchRequestDAOImpl implements SearchRequestDAO {

	@Override
	public SearchRequest saveSearchRequest(SearchRequest searchRequest) {
		return searchRequest;
	}

	@Override
	public SearchRequest deleteSearchRequest(SearchRequest searchRequest) {
		return searchRequest;
	}

	@Override
	public SearchRequest retrieveSearchRequest(SearchRequest searchRequest) {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			String entityType = searchRequest.getEntityType();
			String sql = getQuery(searchRequest);

			connection = getDBConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			ResultSetMetaData resultSetMetadata = rs.getMetaData();
			int columnCount = resultSetMetadata.getColumnCount();

			while (rs.next()) {
				SearchResult result = new SearchResult();

				for (int index = 1; index <= columnCount; index++) {

					Field field = new Field();

					String columnName = resultSetMetadata.getColumnName(index);
					int columnType = resultSetMetadata.getColumnType(index);
					Object value = rs.getObject(index);
					field.setFieldName(columnName);
					field.setFieldValue(value);
					field.setFieldType(String.valueOf(columnType));
					result.getFields().add(field);
				}
				searchRequest.getResults().add(result);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(connection);
		}

		return searchRequest;
	}

	private String getQuery(SearchRequest searchRequest) {
		StringBuilder sb = new StringBuilder();
		buildCriteriaColumns(searchRequest, sb);
		buildTableName(searchRequest, sb);
		buildWhereClause(searchRequest, sb);
		buildOrderBy(searchRequest, sb);
		return sb.toString();
	}

	private void buildOrderBy(SearchRequest searchRequest, StringBuilder sb) {
		String entityType = searchRequest.getEntityType();
		ShowColumn showColumn = searchRequest.getSelectedColumn();

		if (showColumn == null) {
			return;
		}
		sb.append(" ORDER BY ");
		String orderDirection = showColumn.getOrder();
		String columnName = getColumnName(entityType, showColumn.getOrderBy());

		// Append the column name and order direction
		sb.append(columnName).append(" ").append(orderDirection);

	}
		
	

	private void buildWhereClause(SearchRequest searchRequest, StringBuilder sb) {
		String entityType = searchRequest.getEntityType();
		List<SearchCriteria> searchCriteriaList = searchRequest.getCriterias();

		if (searchCriteriaList == null || searchCriteriaList.isEmpty()) {
			return; // No criteria, no WHERE clause needed
		}

		sb.append(" WHERE ");

		for (int i = 0; i < searchCriteriaList.size(); i++) {
			SearchCriteria searchCriteria = searchCriteriaList.get(i);
			String fieldName = searchCriteria.getFieldName();
			Object value = searchCriteria.getValue();
			String condition = searchCriteria.getCondition();
			String columnName = getColumnName(entityType, fieldName);

			// Append the column name and value
			// sb.append(columnName).append(" = '").append(value).append("'");
			String dbCondition = null;
			if(condition.equals("equals")) {
				dbCondition="=";
			}
			else if(condition.equals("not_equals")) {
				dbCondition="!=";
			}
			else if(condition.equals("greater_than")) {
				dbCondition=">";
			}
			else if(condition.equals("contains")) {
				dbCondition="%"+value+"%";
			}
			else if(condition.equals("startswith")) {
				dbCondition=value+"%";
			}
			else if(condition.equals("endswith")) {
				dbCondition="%"+value;
			}else if(condition.equals("less_than")) {
				dbCondition="<";
			}
			if(i > 0) {
				sb.append(" AND ");
			}
			sb.append(" " ).append(columnName).append(" ").append(dbCondition).append(" ").append("'").append(value).append("'");

		}
	}

	private void buildTableName(SearchRequest searchRequest, StringBuilder sb) {
		String entityType = searchRequest.getEntityType();
		String tableName = getTableName(entityType);
		sb.append(" ").append(" from ").append(tableName).append(" ");
	}

	private void buildCriteriaColumns(SearchRequest searchRequest, StringBuilder sb) {
		String entityType = searchRequest.getEntityType();
		List<SearchCriteria> searchCriteriaList = searchRequest.getCriterias();
		if (searchCriteriaList == null || searchCriteriaList.isEmpty()) {
			throw new IllegalArgumentException("Search criteria list cannot be null or empty");
		}

		sb.append("SELECT ");

		for (int i = 0; i < searchCriteriaList.size(); i++) {
			SearchCriteria searchCriteria = searchCriteriaList.get(i);
			String fieldName = searchCriteria.getFieldName();
			String columnName = getColumnName(entityType, fieldName);
			if (i>0) {
				sb.append(", ");
			}
			sb.append(columnName);

			
		}
	}

	private String getTableName(String entityType) {
		Map<String, String> map = new HashMap<>();
		map.put("Role", "role");
		map.put("User", "user");
		map.put("Access", "access");
		map.put("WorkQueue", "work_queue");
		map.put("SupportRequest", "support_request");

		return map.get(entityType);

	}

	private String getColumnName(String entityType, String fieldName) {
		Map<String, Map<String, String>> map = new HashMap<>();
		map.put("Role", getRoleFieldMap());
		map.put("User", getUserFieldMap());
		map.put("Access", getAccessFieldMap());
		map.put("WorkQueue", getWorkQueueFieldMap());
		map.put("SupportRequest", getSupportRequestFieldMap());
		Map<String, String> fieldMap = map.get(entityType);
		if (fieldMap == null) {
			throw new IllegalArgumentException("Invalid entity type: " + entityType);
		}

		String columnName = fieldMap.get(fieldName);
		if (columnName == null) {
			throw new IllegalArgumentException("Invalid field name: " + fieldName + " for entity type: " + entityType);
		}
		return columnName;
		// return map.get(entityType).get(fieldName);
	}

	private Map<String, String> getAccessFieldMap() {
		Map<String, String> map = new HashMap<>();// is need to put id in this
		map.put("accessName", "access_name");
		map.put("accessDescription", "access_description");
		return map;
	}

	private Map<String, String> getUserFieldMap() {
		Map<String, String> map = new HashMap<>();// is need to put id in this
		map.put("firstName", "first_name");
		map.put("lastName", "last_name");
		map.put("email", "email");
		map.put("loginId", "login_id");
		map.put("password", "password");
		map.put("department", "department");
		map.put("isActive", "is_active");
		return map;
	}

	private Map<String, String> getSupportRequestFieldMap() {
		Map<String, String> map = new HashMap<>();
		map.put("entityCode", "entity_code");
		map.put("entityType", "entity_type");
		map.put("entityStatus", "entity_status");
		map.put("requestType", "request_type");
		map.put("requestCode", "request_code");
		map.put("requestDescription", "request_description");
		map.put("failureInfo", "failure_info");
		map.put("failureDate", "failure_date");
		map.put("activityCode", "activity_code");
		map.put("activityStatus", "activity_status");
		map.put("activityComments", "activity_comments");
		map.put("activityType", "activity_type");
		return map;
	}

	private Map<String, String> getWorkQueueFieldMap() {
		Map<String, String> map = new HashMap<>();
		map.put("workQueueName", "work_queue_name");
		map.put("accessType", "access_type");
		map.put("entityType", "entity_type");
		map.put("entityCode", "entity_code");
		map.put("entityStatus", "entity_status");

		return map;

	}

	private Map<String, String> getRoleFieldMap() {
		Map<String, String> map = new HashMap<>();
		map.put("roleName", "role_name");
		map.put("roleDescription", "role_description");
		// Add other Role field mappings here
		return map;
	}

	private static Connection getDBConnection() throws Exception {
		Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
		System.out.println("connection is created");
		return connection;
	}

	private static void close(AutoCloseable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
