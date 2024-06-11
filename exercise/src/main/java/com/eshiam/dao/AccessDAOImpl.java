package com.eshiam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.eshiam.domain.Access;

public class AccessDAOImpl implements AccessDAO {

	@Override
	public Access insertAccess(Access access) {
		String accessDataFromDB;
		try {
			accessDataFromDB = retrieveAccessName(access, access.getAccessName());
			System.out.println("Access Data From DB:" + accessDataFromDB);
			if (access != null && accessDataFromDB != null && access.getAccessName().equalsIgnoreCase(accessDataFromDB)) {
					access = updateAccess(access);
			} else if (access != null && access.getId() == 0) {
				Connection connection = null;
				try {
					connection = getDBConnection();
					insertAccessData(connection, access);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					close(connection);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return access;
	}

	private String retrieveAccessName(Access access2, String accessName) throws Exception {
		Connection connection = getDBConnection();
		Statement stmt = null;
		ResultSet rs = null;
		stmt = connection.createStatement();
		String sql = "";
		accessName = "Dummy";
		if (accessName != null) {
			sql = "select * from sys.access where access_name='" + access2.getAccessName() + "'";
		}
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				accessName = rs.getString("access_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);

		}

		return accessName;

	}

	private void insertAccessData(Connection connection, Access access) throws Exception {
		String sql = "insert into sys.access (id,access_name,access_description,created_date) values (?,?,?,?)";
		Statement stmt = connection.createStatement();
		access.setId(getMaxId(stmt, "select max(id) from sys.access"));
		sql = sql.replaceFirst("\\?", " " + access.getId());
		sql = sql.replaceFirst("\\?", getQuotedString(access.getAccessName()));
		sql = sql.replaceFirst("\\?", getQuotedString(access.getAccessDescription()));
		sql = sql.replaceFirst("\\?", "'" + convertDateToDBString(new Date()) + "'");
		int count = stmt.executeUpdate(sql);
		close(stmt);
		System.out.println("inserted Access data is" + count);

	}
	private String convertDateToDBString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String value = format.format(date);
		return value;
	}

	private int getMaxId(Statement stmt, String maxIdQuery) throws SQLException {
		ResultSet rs = stmt.executeQuery(maxIdQuery);
		int maxId = 1;
		if (rs != null && rs.next()) {
			maxId = rs.getInt(1);
			maxId++;
		}
		close(rs);
		return maxId;
	}

	@Override
	public Access updateAccess(Access access) {
		Connection connection = null;
		try {
			connection = getDBConnection();
			updateAccessData(connection, access);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(connection);
		}
		return access;
	}

	private String getQuotedString(String val) {
		if (val == null) {
			return null;
		}
		return "'" + val.trim() + "'";
	}

	private void updateAccessData(Connection connection, Access access) throws SQLException {
		String sql = "update sys.access set access_name=?,access_description=?,updated_date=? where id=?";
		Statement stmt = connection.createStatement();
		sql = sql.replaceFirst("\\?", getQuotedString(access.getAccessName()));
		sql = sql.replaceFirst("\\?", getQuotedString(access.getAccessDescription()));
		sql = sql.replaceFirst("\\?",  "'" + convertDateToDBString(new Date()) + "'");
		try {
			sql = sql.replaceFirst("\\?", " " + retrieveAccessID(access, access.getAccessName()));
			access.setId(retrieveAccessID(access, access.getAccessName()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		int count = stmt.executeUpdate(sql);
		close(stmt);
		System.out.println("Updated Access data is" + count);

	}
	private int retrieveAccessID(Access access2, String accessName) throws Exception {
		Connection connection = getDBConnection();
		Statement stmt = null;
		ResultSet rs = null;
		stmt = connection.createStatement();
		String sql = "";
		accessName = "Dummy";
		int accessID = 0;
		if (accessName != null) {
			sql = "select * from sys.access where access_name='" + access2.getAccessName() + "'";
		}
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				accessID = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);

		}

		return accessID;

	}


	@Override
	public Access retriewAccess(Access access) {
		Connection connection = null;
		try {
			connection = getDBConnection();
			populateAccessData(connection, access);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(connection);
		}

		return access;
	}

	private void close(AutoCloseable closable) {
		if (closable != null) {
			try {
				closable.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private void populateAccessData(Connection connection, Access access) {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			String sql = "";
			if (access.getId() > 0) {
				sql = "select * from sys.access where id=" + access.getId();
			} else if (access.getAccessName() != null) {
				sql = "select * from sys.access where access_name='" + access.getAccessName() + "' and access_description='" +access.getAccessDescription()+"'" ;
			}
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				access.setId(rs.getInt("id"));
				access.setAccessName(rs.getString("access_name"));
				access.setAccessDescription(rs.getString("access_description"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);

		}
	}

	private Connection getDBConnection() throws Exception {
		Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "root");
		return connection;

	}

	@Override
	public Access deleteAccess(Access access) {
		Connection connection = null;
		try {
			connection = getDBConnection();
			deleteAccessData(connection, access);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(connection);
		}
		return access;
	}

	private void deleteAccessData(Connection connection, Access access) throws SQLException {
		Statement stmt = connection.createStatement();
		String sql = "";
		try {
			sql = "select * from sys.access where id=" +retrieveAccessID(access, access.getAccessName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		int count = stmt.executeUpdate(sql);
		System.out.println("deleted data from sys.access" + count);
		close(stmt);

	}

}
