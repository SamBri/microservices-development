package com.samuel.users.schemas;

import com.samuel.users.UserIdentity;

public class CreateUserSchema {
	
	private String name;
	
	private String mobileNumber;
	
	private UserIdentity myIdentity;
	
	public CreateUserSchema() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateUserSchema(String name, String mobileNumber) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	
	
	public UserIdentity getMyIdentity() {
		return myIdentity;
	}

	public void setMyIdentity(UserIdentity myIdentity) {
		this.myIdentity = myIdentity;
	}

	@Override
	public String toString() {
		return "CreateUserSchema [name=" + name + ", mobileNumber=" + mobileNumber + ", myIdentity=" + myIdentity + "]";
	}

	
	
	
	
}
