package com.eshiam.service;

import com.eshiam.domain.Access;
import com.eshiam.domain.ServiceDTO;

public interface AccessService {
	public ServiceDTO<Access> save(Access access) throws Exception;
	public ServiceDTO<Access> retriew(Access access);
	public ServiceDTO<Access> delete(Access access);

}