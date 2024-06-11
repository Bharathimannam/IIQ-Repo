package com.eshiam.domain;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable{
	private int id;
	private String userName;
	private int loginId;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, loginId, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id && loginId == other.loginId && Objects.equals(userName, other.userName);
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", loginId=" + loginId + "]";
	}


	
	
}
