package com.eshiam.service;

import com.eshiam.dao.RoleDAO;
import com.eshiam.dao.RoleDAOImpl;
import com.eshiam.domain.Role;
import com.eshiam.domain.ServiceDTO;
import com.eshiam.validations.RoleValidator;
import com.eshiam.validations.RoleValidatorImpl;

public class RoleServiceImpl implements RoleService{
	
	private RoleValidator validator=new RoleValidatorImpl();
	private RoleDAO dao=new RoleDAOImpl();

	@Override
	public ServiceDTO<Role> save(Role role) {
		ServiceDTO<Role> dto=new ServiceDTO<Role>();
		dto.setDataObject(role);
		validator.validateRole(dto);
		if(dto.getSeverity()<5) {
			Role dbRole=dao.insertRole(role);
			dto.setDataObject(dbRole);
		}
		return dto;
	}

	@Override
	public ServiceDTO<Role> retriew(Role role) {
		ServiceDTO<Role> dto=new ServiceDTO<Role>();
		dto.setDataObject(role);
		if(role!=null) {
			Role dbRole=dao.retriewRole(role);
			dto.setDataObject(dbRole);
		}
		return dto;
	}

	@Override
	public ServiceDTO<Role> delete(Role role) {
		ServiceDTO<Role> dto=new ServiceDTO<Role>();
		dto.setDataObject(role);
		if(role!=null) {
			Role dbRole=dao.deleteRole(role);
			dto.setDataObject(dbRole);
		}
		return dto;
	}

}
