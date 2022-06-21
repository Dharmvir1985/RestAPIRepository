package com.rest.web.services.restAPIwebservices.bean;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class UserBean {
	
	private int UserId;
	
	@Size(min=2,message="The Name should have at least 2 charactors")
	private String UserName;
	
	@Past
	private Date UserDOB;
	
	protected UserBean() {
		
	}
	
	public UserBean(int userId, String userName,Date date) {
		super();
		UserId = userId;
		UserName = userName;
		UserDOB = (Date) date;
	}
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public Date getUserDOB() {
		return UserDOB;
	}
	public void setUserDOB(Date userDOB) {
		UserDOB = userDOB;
	}
	
	@Override
	public String toString() {
		return "UserBean [UserId=" + UserId + ", UserName=" + UserName + ", UserDOB=" + UserDOB + "]";
	}
	

}
