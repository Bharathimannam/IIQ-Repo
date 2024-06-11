package com.eshiam.domain;

import java.io.Serializable;
import java.util.Objects;

public class AppMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6362750764806261606L;
	private String messageCode;
	private String message;
	private int severity;
	private String fieldKey;
	
	public AppMessage() {
		
	}

	public AppMessage(String msgCode, String msgDescription, int msgSeverity, String fieldKey) {
		this.messageCode = msgCode;
		this.message = msgDescription;
		this.severity = msgSeverity;
		this.fieldKey = fieldKey;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFieldKey() {
		return fieldKey;
	}

	public void setFieldKey(String fieldKey) {
		this.fieldKey = fieldKey;
	}

	public int getSeverity() {
		return severity;
	}

	public void setSeverity(int severity) {
		this.severity = severity;
	}


	@Override
	public int hashCode() {
		return Objects.hash(fieldKey, message, messageCode, severity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppMessage other = (AppMessage) obj;
		return fieldKey == other.fieldKey && Objects.equals(message, other.message)
				&& Objects.equals(messageCode, other.messageCode) && severity == other.severity;
	}

	@Override
	public String toString() {
		return "AppMessage [messageCode=" + messageCode + ", message=" + message + ", severity=" + severity
				+ ", fieldKey=" + fieldKey + "]";
	}
	

}
