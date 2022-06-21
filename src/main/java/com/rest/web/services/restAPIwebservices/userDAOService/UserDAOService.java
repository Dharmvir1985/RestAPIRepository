package com.rest.web.services.restAPIwebservices.userDAOService;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rest.web.services.restAPIwebservices.bean.UserBean;

@Component
public class UserDAOService {
	
	private static int countUser=3;
	
	private static List<UserBean> users=new ArrayList<UserBean>();
	
	static {
		users.add(new UserBean(1,"Adam",new Date()));
		users.add(new UserBean(2,"Eve",new Date()));
		users.add(new UserBean(3,"Jack",new Date()));
	}
	
	public List<UserBean>findAll(){
		return users;
	}
	
	public UserBean save(UserBean user){
		
		if(user.getUserId()==0) {
			user.setUserId(++countUser);
		}
		
		users.add(user);
		return  user;
	}
	

public UserBean findOne(int id){
		
		for(UserBean user: users) {
			System.out.println();
			if(user.getUserId()==id) {
				return  user;
			}
		}
		return null;
	}
public UserBean deleteById(int id){
	
	
	Iterator<UserBean>iterator=users.iterator();
	while(iterator.hasNext()) {
		UserBean user=iterator.next();
		if(user.getUserId()==id) {
			iterator.remove();
			return  user;
		}
	}
	return null;
}



}
