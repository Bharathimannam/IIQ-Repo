package com.eshiam.validations;
import com.eshiam.domain.Role;
import com.eshiam.domain.ServiceDTO;

public interface RoleValidator {
	public void validateRole(ServiceDTO<Role> dto);

}
