package com.rest.web.services.restAPIwebservices.bean;

public class HelloWorldBin {
	
	private String message;

	public HelloWorldBin(String message) {
		
		this.message = message;
	}

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBin [message=" + message + "]";
	}

}
