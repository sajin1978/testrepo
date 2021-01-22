package com.examples.testexamples.testexamples.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.springframework.data.domain.Persistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="role")
public class Role implements Persistable<String> {
	
	@Id
	@Column(name="roleid")
	private String roleid;
	
	@Column(name="rolename")
	private String rolename;
	
	
	@Version
	@Column(name="roleversion")
	private Integer rowversion;
	
	@ManyToOne
	@JoinColumn(name="uuid")
	private Employee uuid;

	public Employee getUuid() {
		return uuid;
	}


	public void setUuid(Employee uuid) {
		this.uuid = uuid;
	}


	@Transient
	@JsonIgnore
	private boolean isNew;
	
	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}


	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	

	public Role(String roleid, String rolename, Integer rowversion, Employee uuid, boolean isNew) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
		this.rowversion = rowversion;
		this.uuid = uuid;
		this.isNew = isNew;
	}


	public String getRoleid() {
		return roleid;
	}


	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}


	public String getRolename() {
		return rolename;
	}


	public void setRolename(String rolename) {
		this.rolename = rolename;
	}


	public Integer getRowversion() {
		return rowversion;
	}


	public void setRowversion(Integer rowversion) {
		this.rowversion = rowversion;
	}


	@Override
	public String toString() {
		return "Role [roleid=" + roleid + ", rolename=" + rolename + ", rowversion=" + rowversion + "]";
	}


	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return roleid;
	}


	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return isNew;
	}
	

}
