package com.rest.web.services.restAPIwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rest.web.services.restAPIwebservices.bean.HelloWorldBin;

@RestController
public class HelloWordController {
	
	
	@GetMapping( path ="/hello-World")
	public String helloWorld() {
		
		return "Hellow World";
	}
	
	@GetMapping( path ="/hello-World-bin")
	public HelloWorldBin helloWorldBin() {
		
		return new HelloWorldBin("Hellow World bin");
	}
	@GetMapping( path ="/hello-World-bin/pathVariable/{name}")
	public HelloWorldBin helloWorldBinPathVariable(@PathVariable String name) {
		
		return new HelloWorldBin(String.format("Hellow World:%s", name));
	}
}
