package com.eshiam.service;

import com.eshiam.domain.Role;
import com.eshiam.domain.ServiceDTO;

public interface RoleService {
	public ServiceDTO<Role> save(Role role);
	public ServiceDTO<Role> retriew(Role role);
	public ServiceDTO<Role> delete(Role role);


}