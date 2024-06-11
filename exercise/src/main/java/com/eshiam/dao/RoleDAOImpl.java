package com.eshiam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.eshiam.domain.Access;
import com.eshiam.domain.Role;
import com.eshiam.domain.RoleToAccess;

public class RoleDAOImpl implements RoleDAO {

	@Override
	public Role insertRole(Role role) {
		if (role != null && role.getId() > 0) {
			role = updateRole(role);
		} else if (role != null && role.getId() == 0) {
			Connection connection = null;
			try {
				connection = getDBConnection();
				insertRoleData(connection, role);
				insertRoleToAccessData(connection, role);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(connection);
			}
		}

		return role;
	}

	private void insertRoleToAccessData(Connection connection, Role role) throws SQLException {
		for (RoleToAccess roleToAccess : role.getAccessList()) {
			if (roleToAccess.getId() > 0) {
				updateRoleToAccessTableData(connection, role, roleToAccess);
			}
			insertRoleToAccessTableData(connection, role, roleToAccess);

		}
	}

	private void insertRoleData(Connection connection, Role role) throws SQLException {
		String sql = "insert into sys.role (id,role_name,role_description,created_date) values (?,?,?,?)";
		Statement stmt = connection.createStatement();
		role.setId(getMaxId(stmt, "select max(id) from sys.role"));
		sql = sql.replaceFirst("\\?", " " + role.getId());
		sql = sql.replaceFirst("\\?", getQuotedString(role.getRoleName()));
		sql = sql.replaceFirst("\\?", getQuotedString(role.getRoleDescription()));
		sql = sql.replaceFirst("\\?", "'" + convertDateToDBString(new Date()) + "'");
		int count = stmt.executeUpdate(sql);
		close(stmt);
		System.out.println("inserted Role data is" + count);

	}
	private String convertDateToDBString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String value = format.format(date);
		return value;
	}

	@Override
	public Role updateRole(Role role) {
		Connection connection = null;
		try {
			connection = getDBConnection();
			updateRoleData(connection, role);
			updateRoleToAccessData(connection, role);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(connection);
		}
		return role;
	}

	private void updateRoleToAccessData(Connection connection, Role role) throws SQLException {
		for (RoleToAccess roleToAccess : role.getAccessList()) {
			if (roleToAccess.getId() > 0) {
				updateRoleToAccessTableData(connection, role, roleToAccess);
			}
			insertRoleToAccessTableData(connection, role, roleToAccess);

		}

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

	private void insertRoleToAccessTableData(Connection connection, Role role, RoleToAccess roleToAccess)
			throws SQLException {
		Statement stmt = connection.createStatement();
		int role_id=getRoleID(connection,role);
		String sql = "insert into sys.role_to_access(id,role_id, access_names) values (?,?,?)";
		roleToAccess.setId(getMaxId(stmt, "select max(id) from sys.role_to_access"));
		sql = sql.replaceFirst("\\?", " " + roleToAccess.getId());
		sql = sql.replaceFirst("\\?", " " + role_id);
		sql = sql.replaceFirst("\\?", getQuotedString(roleToAccess.getAccessName()));

		int count = stmt.executeUpdate(sql);
		close(stmt);
		System.out.println("inserted role to access data" + count);

	}

	private int getRoleID(Connection connection,Role role) throws SQLException {
		Statement stmt = connection.createStatement();
		ResultSet rs = null;
		int id = 0;
		String sql = "select id from sys.role where role_name='" + role.getRoleName()+"'";
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			id=rs.getInt("id");
		}
		close(rs);
		close(stmt);
		return id;
	}

	private void updateRoleToAccessTableData(Connection connection, Role role, RoleToAccess roleToAccess)
			throws SQLException {
		Statement stmt = connection.createStatement();
		String sql = "update sys.role_to_access set role_id=?, access_names=? where id=?";
		sql = sql.replaceFirst("\\?", " " + roleToAccess.getRoleId());
		sql = sql.replaceFirst("\\?", " " + roleToAccess.getAccessName());
		sql = sql.replaceFirst("\\?", " " + roleToAccess.getId());
		int count = stmt.executeUpdate(sql);
		close(stmt);
		System.out.println("updated roleAccessData" + count);

	}

	private void updateRoleData(Connection connection, Role role) throws SQLException {
		String sql = "update sys.role set role_name=?,role_description=?,updated_date=? where id=?";
		Statement stmt = connection.createStatement();
		sql = sql.replaceFirst("\\?", getQuotedString(role.getRoleName()));
		sql = sql.replaceFirst("\\?", getQuotedString(role.getRoleDescription()));
		sql = sql.replaceFirst("\\?",  "'" + convertDateToDBString(new Date()) + "'");
		sql = sql.replaceFirst("\\?", " " + role.getId());
		int count = stmt.executeUpdate(sql);
		close(stmt);
		System.out.println("inserted role data is" + count);

	}

	private String getQuotedString(String val) {
		if (val == null) {
			return null;
		}
		return "'" + val.trim() + "'";
	}

	@Override
	public Role retriewRole(Role role) {
		Connection connection = null;
		try {
			connection = getDBConnection();
			populateRoleData(connection, role);
			populateRoleToAccessData(connection, role);
			populateAccessData(connection, role);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(connection);
		}

		return role;
	}

	private void populateAccessData(Connection connection, Role role) {
		Statement stmt = null;
		ResultSet rs = null;
		Access access=new Access();
		try {
			stmt = connection.createStatement();
			String sql = "";
			if (access.getId() > 0) {
				sql = "select * from sys.access where id=" + access.getId();
			} else if (access.getAccessName() != null) {
				sql = "select * from sys.access where access_name=" + access.getAccessName();
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

	private void populateRoleToAccessData(Connection connection, Role role) throws SQLException {
		String sql = "select * from sys.role_to_access where role_id=" + role.getId();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			RoleToAccess roleToAccess = new RoleToAccess();
			Access access = new Access();
			access.setId(rs.getInt("access_id"));
			roleToAccess.setAccessName(rs.getString("access_names"));
			roleToAccess.setRoleId(rs.getInt("role_id"));
			roleToAccess.setId(rs.getInt("id"));
			role.getAccessList().add(roleToAccess);
			close(rs);
			close(stmt);
		}

	}

	private void populateRoleData(Connection connection, Role role) {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			String sql = "";
			if (role.getId() > 0) {
				sql = "select * from sys.role where id=" + role.getId();
			} else if (role.getRoleName() != null) {
				sql = "select * from sys.role where role_name=" + role.getRoleName();
			}
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				role.setId(rs.getInt("id"));
				role.setRoleName(rs.getString("role_name"));
				role.setRoleDescription(rs.getString("role_description"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);

		}

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

	private Connection getDBConnection() throws Exception {
		Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "root");
		return connection;

	}
	@Override
	public List<String> populateRoleNameData() {
		Connection connection=null;
		Statement stmt = null;
		ResultSet rs = null;
		List<String> roleNamesList= new ArrayList<>();
			try {
				connection = getDBConnection();
				stmt = connection.createStatement();
				String sql ="select role_name from sys.role";
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					roleNamesList.add(rs.getString("role_name"));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
			close(rs);
			close(stmt);

		}
		return roleNamesList;
	}
	@Override
	public List<String> populateAccessListData() {
		Connection connection=null;
		Statement stmt = null;
		ResultSet rs = null;
		List<String> accessNamesList= new ArrayList<>();
			try {
				connection = getDBConnection();
				stmt = connection.createStatement();
				String sql ="select access_name from sys.access";
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					accessNamesList.add(rs.getString("access_name"));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
			close(rs);
			close(stmt);

		}
		return accessNamesList;
	}

	@Override
	public Role deleteRole(Role role) {
		Connection connection = null;
		try {
			connection = getDBConnection();
			deleteRoleToAccessData(connection, role);
			deleteRoleData(connection, role);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(connection);
		}
		return role;
	}

	private void deleteRoleData(Connection connection, Role role) throws SQLException {
		Statement stmt = connection.createStatement();
		String sql = "select * from sys.role where id=" + role.getId();
		int count = stmt.executeUpdate(sql);
		System.out.println("deleted data from sys.role" + count);
		close(stmt);

	}

	private void deleteRoleToAccessData(Connection connection, Role role) throws SQLException {
		Statement stmt = connection.createStatement();
		String sql = "select * from sys.role_to_access where role_id=" + role.getId();
		int count = stmt.executeUpdate(sql);
		System.out.println("deleted data from sys.role_to_access" + count);
		close(stmt);

	}

}
