package com.examples.testexamples.testexamples.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.testexamples.testexamples.dao.EmployeeDao;
import com.examples.testexamples.testexamples.dao.RoleDao;
import com.examples.testexamples.testexamples.dto.CustomerResponse;
import com.examples.testexamples.testexamples.entity.Address;
import com.examples.testexamples.testexamples.entity.Employee;
import com.examples.testexamples.testexamples.entity.Role;
import com.examples.testexamples.testexamples.util.DataServiceUtil;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	RoleDao roleDao;
	
	public Employee save(Employee employee) {
		employee.setUuid(DataServiceUtil.generateUniqueId());
		List<Address> addressList = employee.getAddress();
		addressList.forEach(address->{
			address.setAddressid(DataServiceUtil.generateUniqueId());
			address.setUuid(employee.getUuid());
		});
		
		return this.employeeDao.save(employee);
	}
	
	
	public Role saveRole(Role role) {
		return this.roleDao.save(role);
	}
	
	public List<Role> getRole(){
		return this.roleDao.findAll();
	}
	
	public List<Employee> getAll(){
		return this.employeeDao.findAll();
	}
	
	public List<CustomerResponse> getCustomerInformation(){
		return employeeDao.getCustomerInformation();
	}
	
	
	public Optional<Employee> getById(String id) {
		return this.employeeDao.findById(id);
	}

	public int bulkDelete(String uuid,String name) {
		int result = 0;
		result = this.employeeDao.deleteByUuidAndName(uuid,name);
		return result;
	}

}
