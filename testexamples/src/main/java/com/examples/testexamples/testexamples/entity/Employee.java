package com.examples.testexamples.testexamples.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.domain.Persistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employee")
@NamedQueries(value= {
		@NamedQuery(name="Employee.deleteByuuid",
			query="delete from Employee emp where emp.uuid=:uuid and emp.name=:name"	
			)
})
public class Employee implements Persistable<String>{
   
	
	
	@Id
	@Column(name="uuid")
	private String uuid;
	
	@ManyToOne
	@JoinColumn(name="roleid")
	private Role roleid;
	
	
	
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name="uuid", updatable = false, insertable = false)
	private List<Address> address;
	
	
	
	
	@Column(name="name")
	private String name;
	

	@Transient
	@JsonIgnore
	private boolean isNew;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role getRoleid() {
		return roleid;
	}

	public void setRoleid(Role roleid) {
		this.roleid = roleid;
	}

	public Employee(String uuid, Role roleid, List<Address> address, String name, boolean isNew) {
		super();
		this.uuid = uuid;
		this.roleid = roleid;
		this.address = address;
		this.name = name;
		this.isNew = isNew;
	}







	public String getUuid() {
		return uuid;
	}



	public void setUuid(String uuid) {
		this.uuid = uuid;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public List<Address> getAddress() {
		return address;
	}



	public void setAddress(List<Address> address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return "Employee [uuid=" + uuid + ", name=" + name + "]";
	}



	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return uuid;
	}



	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return isNew;
	}



	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}
	
	
}
