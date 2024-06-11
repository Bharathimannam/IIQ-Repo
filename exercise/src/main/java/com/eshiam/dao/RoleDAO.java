package com.eshiam.dao;
import java.util.List;

import com.eshiam.domain.Role;

public interface RoleDAO {
public  Role insertRole(Role role);
	
	public  Role updateRole(Role role);
	
	public  Role retriewRole(Role role);
	
	public  Role deleteRole(Role role);
	
	public List<String> populateRoleNameData();
	
	public List<String> populateAccessListData();

}
