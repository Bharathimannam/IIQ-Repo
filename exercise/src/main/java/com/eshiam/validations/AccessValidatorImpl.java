package com.eshiam.validations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.eshiam.domain.Access;
import com.eshiam.domain.ServiceDTO;

public class AccessValidatorImpl implements AccessValidator {

	@Override
	public void validateAccess(ServiceDTO<Access> dto) {
		Access access = dto.getDataObject();
		if (access != null) {
			// validateAccessId(dto);
			validateAccessName(dto);
			validateAccessDescription(dto);
			/*
			 * validateCreatedDate(dto); validateUpdatedDate(dto); validateCreatedById(dto);
			 * validateUpdatedById(dto); validateCreatedByUser(dto);
			 * validateUpdatedByUser(dto);
			 */
		} else {
			dto.addAppMessage("ACCESS01", "Please check whether you have access", 5, "accessName");
		}
	}
	private void validateAccessDescription(ServiceDTO<Access> dto) {
		Access access = dto.getDataObject();
		if (access.getAccessDescription() == null || access.getAccessDescription().trim().length() == 0) {
			dto.addAppMessage("ACCESS004", "Please enter Access Description", 5, "accessDescription");
		} else if (access.getAccessDescription().length() > 200) {
			dto.addAppMessage("ACCESS005", "Access Description should be within 200 characters", 5,
					"accessDescription");

		}

	}

	private void validateAccessName(ServiceDTO<Access> dto) {
		Access access = dto.getDataObject();
		if (access.getAccessName() == null || access.getAccessName().trim().length() == 0) {
			dto.addAppMessage("ACCESS002", "Please enter Access name", 5, "accessName");
		} /*
			 * else if (!getAccessNamesAllowedValues().contains(access.getAccessName())) {
			 * dto.addAppMessage("ACCESS003", "Please enter valid Access name", 5,
			 * "accessName");
			 * 
			 * }
			 */

	}

	/*
	 * private List<String> getAccessNamesAllowedValues() { List<String> accessName
	 * = new ArrayList<>(); accessName.add("AccountingGeneral");
	 * accessName.add("AccountsReceivable"); accessName.add("Admins");
	 * accessName.add("AuditMgmt"); accessName.add("All_Users");
	 * accessName.add("Buyer"); accessName.add("Benefits");
	 * accessName.add("Contractors"); accessName.add("Executive");
	 * accessName.add("Finance"); accessName.add("HR"); accessName.add("IT");
	 * accessName.add("Development"); return accessName; }
	 */

	/*
	 * private void validateAccessId(ServiceDTO<Access> dto) { Access
	 * access=dto.getDataObject(); if(access.getId() == 0) {
	 * dto.addAppMessage("ACCESS014","Please enter valid access ID",5,"id"); } }
	 */
	/*
	 * private void validateUpdatedByUser(ServiceDTO<Access> dto) { Access
	 * access=dto.getDataObject(); if(access.getUpdatedByUser()==null ||
	 * access.getUpdatedByUser().trim().length() == 0) {
	 * dto.addAppMessage("ACCESS013","Please enter access Updated user name",5,
	 * "updatedByUser"); } }
	 * 
	 * private void validateCreatedByUser(ServiceDTO<Access> dto) { Access
	 * access=dto.getDataObject(); if(access.getCreatedByUser()==null ||
	 * access.getCreatedByUser().trim().length() == 0) {
	 * dto.addAppMessage("ACCESS012","Please enter access created user name",5,
	 * "createdByUser"); } }
	 * 
	 * private void validateUpdatedById(ServiceDTO<Access> dto) { Access
	 * access=dto.getDataObject(); if(access.getUpdatedBy() == 0) {
	 * dto.addAppMessage("ACCESS011","Please enter Updated By UserID",5,"updatedBy")
	 * ; } }
	 * 
	 * private void validateCreatedById(ServiceDTO<Access> dto) { Access
	 * access=dto.getDataObject(); if(access.getCreatedBy() == 0) {
	 * dto.addAppMessage("ACCESS010","Please enter Created By UserID",5,"createdBy")
	 * ; } }
	 * 
	 * private void validateUpdatedDate(ServiceDTO<Access> dto) { Access
	 * access=dto.getDataObject(); if(access.getUpdatedDate()==null) {
	 * dto.addAppMessage("ACCESS008","Please enter Access Updated Date",5,
	 * "updatedDate"); }else if(access.getUpdatedDate().compareTo(new Date()) > 0) {
	 * dto.addAppMessage(
	 * "ACCESS009","Date should be less than or equal to current date",5,
	 * "updatedDate"); } else
	 * if(access.getUpdatedDate().compareTo(access.getCreatedDate()) <= 0) {
	 * dto.addAppMessage(
	 * "ACCESS009","Date should be less than or equal to current date",5,
	 * "updatedDate");
	 * 
	 * }
	 * 
	 * private void validateCreatedDate(ServiceDTO<Access> dto) { Access
	 * access=dto.getDataObject(); if(access.getCreatedDate()==null) {
	 * dto.addAppMessage("ACCESS006","Please enter Access Created Date",5,
	 * "createdDate"); }else if(access.getCreatedDate().compareTo(new Date()) > 0) {
	 * dto.addAppMessage(
	 * "ACCESS007","Date should be less than or equal to current date",5,
	 * "createdDate");
	 * 
	 * } }
	 */

}
