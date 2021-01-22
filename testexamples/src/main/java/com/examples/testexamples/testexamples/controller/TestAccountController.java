package com.examples.testexamples.testexamples.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.examples.testexamples.testexamples.service.TestAccountService;

@RestController
@RequestMapping("v1/accounts")
public class TestAccountController {

	@Autowired
	TestAccountService testAccountService;
	
	@RequestMapping(method=RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<String>> getAll(){
		return new ResponseEntity<List<String>>(testAccountService.getAll(),HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/helloUser",method=RequestMethod.GET)
	public String getHelloUser() {
		return "hello user";
	}
	
	@RequestMapping(value="/helloAdmin",method=RequestMethod.GET)
	public String getHelloAdmin() {
		return "hello Admin";
	}
}
