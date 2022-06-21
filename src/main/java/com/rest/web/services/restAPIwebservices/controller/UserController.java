package com.rest.web.services.restAPIwebservices.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.web.services.restAPIwebservices.bean.UserBean;
import com.rest.web.services.restAPIwebservices.exeptionHandling.UserNotFoundException;
import com.rest.web.services.restAPIwebservices.userDAOService.UserDAOService;

@RestController
public class UserController {
	
	@Autowired
	UserDAOService userDAOService;
	
	
	@GetMapping(path="/users")
	public List<UserBean> retrieveAllUsers() {
		return userDAOService.findAll();
	}
	@GetMapping(path="/users/{id}")
	public UserBean retrieveUser(@PathVariable int id) {
		
		UserBean user= userDAOService.findOne(id);
		
		if(user==null)
			throw new UserNotFoundException("id-"+id);
		
		EntityModel<UserBean> model=EntityModel.of(user);
		
		return user;
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable int id) {
		
		UserBean user= userDAOService.deleteById(id);
		
		if(user==null)
			throw new UserNotFoundException("id-"+id);
	}
	
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> saveUsers(@Valid @RequestBody UserBean userBean ) {
		
		UserBean userBean1=userDAOService.save(userBean);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userBean1.getUserId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
