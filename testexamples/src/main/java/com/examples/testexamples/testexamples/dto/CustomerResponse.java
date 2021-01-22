package com.examples.testexamples.testexamples.dto;

public class CustomerResponse {
	
	private String name;
	
	private String city;
	
	public CustomerResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerResponse(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "CustomerResponse [name=" + name + ", city=" + city + "]";
	}
	

}
