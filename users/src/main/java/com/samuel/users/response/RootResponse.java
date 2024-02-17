package com.samuel.users.response;

public class RootResponse <T> {
	String status;
	String code;
	String message;
	T response;
	
	
	
	public RootResponse() {
	}
	
	public RootResponse(String status, String code, String message, T response) {
		this.status = status;
		this.code = code;
		this.message = message;
		this.response = response;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "RootResponse [status=" + status + ", code=" + code + ", message=" + message + ", response=" + response
				+ "]";
	}

	
	
	
	
	
	

}
