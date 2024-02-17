package com.samuel.users.response;

import java.io.Serializable;

public class CreateUserResponse {
	
	private String userName;
	
	private String userPassword;
	
	private String dateCreated;
	
	private String mobileNumber;
	
	private Integer userId;
	
	private String yourUserIdentity;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getYourUserIdentity() {
		return yourUserIdentity;
	}

	public void setYourUserIdentity(String yourUserIdentity) {
		this.yourUserIdentity = yourUserIdentity;
	}

	@Override
	public String toString() {
		return "CreateUserResponse [userName=" + userName + ", userPassword=" + userPassword + ", dateCreated="
				+ dateCreated + ", mobileNumber=" + mobileNumber + ", userId=" + userId + ", yourUserIdentity="
				+ yourUserIdentity + "]";
	}

	

	
	
	

}
