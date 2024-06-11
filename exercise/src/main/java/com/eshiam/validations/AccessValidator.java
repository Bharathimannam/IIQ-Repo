package com.eshiam.validations;

import com.eshiam.domain.Access;
import com.eshiam.domain.ServiceDTO;

public interface AccessValidator {
	public void validateAccess(ServiceDTO<Access> dto);
}
