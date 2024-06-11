package com.eshiam.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ServiceDTO<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8254910253272555752L;
	private T dataObject;
	private List<AppMessage> messages = new ArrayList<>();
	private int severity;
	public ServiceDTO() {
		
	}
	public T getDataObject() {
		return dataObject;
	}
	public void setDataObject(T dataObject) {
		this.dataObject = dataObject;
	}
	public List<AppMessage> getMessages() {
		return messages;
	}
	public void setMessages(List<AppMessage> messages) {
		this.messages = messages;
	}
	public int getSeverity() {
		return severity;
	}
	public void setSeverity(int severity) {
		this.severity = severity;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dataObject, messages, severity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceDTO other = (ServiceDTO) obj;
		return Objects.equals(dataObject, other.dataObject) && Objects.equals(messages, other.messages)
				&& severity == other.severity;
	}
	@Override
	public String toString() {
		return "ServiceDTO [dataObject=" + dataObject + ", messages=" + messages + ", severity=" + severity + "]";
	}
	public void addAppMessage(String msgCode, String msgDescription, int msgSeverity, String fieldKey) {
   this.getMessages().add(new AppMessage(msgCode,msgDescription,msgSeverity,fieldKey));	
   if(this.severity < msgSeverity) {
	   this.severity = msgSeverity;
   }
	}

}
