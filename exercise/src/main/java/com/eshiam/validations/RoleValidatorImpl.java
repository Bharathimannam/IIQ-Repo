package com.eshiam.validations;
import com.eshiam.domain.Role;
import com.eshiam.domain.ServiceDTO;

public class RoleValidatorImpl implements RoleValidator{

	@Override
	public void validateRole(ServiceDTO<Role> dto) {
		Role role=dto.getDataObject();
		if(role!=null) {
			validateRoleName(dto);
			validateRoleDescription(dto);
			/*
			 * validateCreatedDate(dto); validateUpdatedDate(dto); validateCreatedById(dto);
			 * validateUpdatedById(dto); validateCreatedByUser(dto);
			 * validateUpdatedByUser(dto); validateAccessList(dto);
			 */		
		}else {
			dto.addAppMessage("ROLE001","Please enter role name",5,"roleName");
		}
		
	}

	private void validateAccessList(ServiceDTO<Role> dto) {
		// TODO Auto-generated method stub
		
	}


	/*
	 * private void validateUpdatedByUser(ServiceDTO<Role> dto) { Role
	 * role=dto.getDataObject(); if(role.getUpdatedByUser()==null ||
	 * role.getUpdatedByUser().trim().length() == 0) {
	 * dto.addAppMessage("ROLE013","Please enter role Updated user name",5,
	 * "updatedByUser"); } }
	 * 
	 * private void validateCreatedByUser(ServiceDTO<Role> dto) { Role
	 * role=dto.getDataObject(); if(role.getCreatedByUser()==null ||
	 * role.getCreatedByUser().trim().length() == 0) {
	 * dto.addAppMessage("ROLE012","Please enter role created user name",5,
	 * "createdByUser"); } }
	 * 
	 * private void validateUpdatedById(ServiceDTO<Role> dto) { Role
	 * role=dto.getDataObject(); if(role.getUpdatedBy() == 0) {
	 * dto.addAppMessage("ROLE011","Please enter Updated By UserID",5,"updatedBy");
	 * } }
	 * 
	 * private void validateCreatedById(ServiceDTO<Role> dto) { Role
	 * role=dto.getDataObject(); if(role.getCreatedBy() == 0) {
	 * dto.addAppMessage("ROLE010","Please enter Created By UserID",5,"createdBy");
	 * } }
	 * 
	 * private void validateUpdatedDate(ServiceDTO<Role> dto) { Role
	 * role=dto.getDataObject(); if(role.getUpdatedDate()==null) {
	 * dto.addAppMessage("ROLE008","Please enter Role Updated Date",5,"updatedDate")
	 * ; }else if(role.getUpdatedDate().compareTo(new Date()) > 0) {
	 * dto.addAppMessage(
	 * "ROLE009","Date should be less than or equal to current date",5,"updatedDate"
	 * ); } } private void validateCreatedDate(ServiceDTO<Role> dto) { Role
	 * role=dto.getDataObject(); if(role.getCreatedDate()==null) {
	 * dto.addAppMessage("ROLE006","Please enter Role Created Date",5,"createdDate")
	 * ; }else if(role.getCreatedDate().compareTo(new Date()) > 0) {
	 * dto.addAppMessage(
	 * "ROLE007","Date should be less than or equal to current date",5,"createdDate"
	 * );
	 * 
	 * } }
	 */

	private void validateRoleDescription(ServiceDTO<Role> dto) {
		Role role=dto.getDataObject();
		if(role.getRoleDescription()==null || role.getRoleDescription().trim().length() == 0) {
			dto.addAppMessage("ROLE004","Please enter Role Description",5,"roleDescription");
		}else if(role.getRoleDescription().length()>200) { 
			dto.addAppMessage("ROLE005","Role Description should be within 200 characters",5,"roleDescription");
		
		}
		
	}

	private void validateRoleName(ServiceDTO<Role> dto) {
		Role role=dto.getDataObject();
		if(role.getRoleName()==null || role.getRoleName().trim().length() == 0) {
			dto.addAppMessage("ROLE002","Please enter Role name",5,"roleName");
		} /*
			 * else if(!getRoleNamesAllowedValues().contains(role.getRoleName())) {
			 * dto.addAppMessage("ROLE003","Please enter valid Access name",5,"roleName");
			 * 
			 * }
			 */
		
	}

	/*
	 * private List<String> getRoleNamesAllowedValues() { List<String> roleName =new
	 * ArrayList<>(); roleName.add("Organizational"); roleName.add("Business");
	 * roleName.add("IT"); roleName.add("Entitlement"); return roleName;
	 * 
	 * }
	 */
}


