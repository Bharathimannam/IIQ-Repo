package com.eshiam.service;

import java.io.Serializable;

import com.eshiam.dao.AccessDAO;
import com.eshiam.dao.AccessDAOImpl;
import com.eshiam.domain.Access;
import com.eshiam.domain.ServiceDTO;
import com.eshiam.validations.AccessValidator;
import com.eshiam.validations.AccessValidatorImpl;

public class AccessServiceImpl implements Serializable, AccessService{
	private static final long serialVersionUID = -6366593977697582174L;
	
	private AccessValidator validator=new AccessValidatorImpl();
	private AccessDAO dao=new AccessDAOImpl();

	@Override
	public ServiceDTO<Access> save(Access access) {
		//access.setCreatedDate(LocalDateTime.now());
		ServiceDTO<Access> dto=new ServiceDTO<Access>();
		dto.setDataObject(access);
		validator.validateAccess(dto);
		if(dto.getSeverity()<5) {
			Access dbAccess=dao.insertAccess(access);
			dto.setDataObject(dbAccess);
		}
		return dto;
	}

	@Override
	public ServiceDTO<Access> retriew(Access access) {
		ServiceDTO<Access> dto=new ServiceDTO<Access>();
		dto.setDataObject(access);
		if(access!=null) {
			Access dbAccess=dao.retriewAccess(access);
			dto.setDataObject(dbAccess);
		}
		return dto;
	}

	@Override
	public ServiceDTO<Access> delete(Access access) {
		ServiceDTO<Access> dto=new ServiceDTO<Access>();
		dto.setDataObject(access);
		if(access!=null) {
			Access dbAccess=dao.deleteAccess(access);
			dto.setDataObject(dbAccess);
		}
		return dto;
	}

}
