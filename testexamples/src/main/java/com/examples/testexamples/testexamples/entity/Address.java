package com.examples.testexamples.testexamples.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.domain.Persistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "address")
public class Address implements Persistable<String>{
	
	
	@Id
	@Column(name="addressid")
	private String addressid;
	
	
	@Column(name="city")
	private String city;
	
	
	@Column(name="state")
	private String state;
	
	@Column(name="country")
	private String country;
	
	@Column(name="uuid")
	private String uuid;
	
	
	@Transient
	@JsonIgnore
	private boolean isNew;
	

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Address(String addressid, String city, String state, String country, String uuid, boolean isNew) {
		super();
		this.addressid = addressid;
		this.city = city;
		this.state = state;
		this.country = country;
		this.uuid = uuid;
		this.isNew = isNew;
	}



	public String getUuid() {
		return uuid;
	}



	public void setUuid(String uuid) {
		this.uuid = uuid;
	}



	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}



	public String getAddressid() {
		return addressid;
	}

	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [addressid=" + addressid + ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return addressid;
	}

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return isNew;
	}
	
}
	
	
