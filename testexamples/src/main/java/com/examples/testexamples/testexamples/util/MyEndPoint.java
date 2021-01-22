package com.examples.testexamples.testexamples.util;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="xadmin", enableByDefault=true)
public class MyEndPoint {

	@ReadOperation
	public MyEndPointResponse endPoing() {
		return new MyEndPointResponse(1001,"xadmin-Ashish","Active");
	}
}


class MyEndPointResponse{
	
	private int id;
	private String name;
	private String response;
	
	public MyEndPointResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyEndPointResponse(int id, String name, String response) {
		super();
		this.id = id;
		this.name = name;
		this.response = response;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	
	
	
}