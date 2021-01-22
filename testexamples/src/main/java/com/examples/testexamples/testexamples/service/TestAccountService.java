package com.examples.testexamples.testexamples.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TestAccountService {

	
	public List<String> getAll(){
		List<String> testStringList = new ArrayList<>();
		testStringList.add("testing1");
		testStringList.add("testing2");
		testStringList.add("testing3");
		return testStringList;
	}
}
