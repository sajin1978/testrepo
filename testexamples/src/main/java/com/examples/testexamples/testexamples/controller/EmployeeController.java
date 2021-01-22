package com.examples.testexamples.testexamples.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examples.testexamples.testexamples.dto.CustomerResponse;
import com.examples.testexamples.testexamples.entity.Employee;
import com.examples.testexamples.testexamples.entity.Role;
import com.examples.testexamples.testexamples.service.EmployeeService;
import com.examples.testexamples.testexamples.util.DataServiceUtil;

@RestController
@RequestMapping("v1/employee")
public class EmployeeController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	
	@Autowired 
	EmployeeService empService;
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Employee> getById(@PathVariable String id) {
		return this.empService.getById(id);

	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAll(){
		logger.info("Start of EmployeeController--> getAll method ");
		List<Employee> empList = this.empService.getAll();
		System.out.println("the size of empList is "+empList.size());
		
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="/roles",method = RequestMethod.GET)
	public ResponseEntity<List<Role>> getRole(){
		
		List<Role> roleList = this.empService.getRole();
		System.out.println("the size of roleList is "+roleList.size());
		
		return new ResponseEntity<List<Role>>(roleList,HttpStatus.OK);
	} 
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee add(@RequestBody Employee employee) {
		employee.setUuid(DataServiceUtil.generateUniqueId());
		employee.setNew(true);
		Employee emp= this.empService.save(employee);
		System.out.println("employee got saved "+ emp.getId());
		return emp;
	}
	
	
	@RequestMapping(value="/addrole", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Role add(@RequestBody Role role) {
		role.setRoleid(DataServiceUtil.generateUniqueId());
		role.setNew(true);
		
		role= this.empService.saveRole(role);
		System.out.println("employee got saved "+ role.getRoleid());
		return role;
	}
	
	@RequestMapping(value="/empdetails", method = RequestMethod.GET)
	public ResponseEntity<List<CustomerResponse>>  getempDetails(){
		List<CustomerResponse> empList = this.empService.getCustomerInformation();
		return new ResponseEntity<List<CustomerResponse>>(empList,HttpStatus.OK);
	}
	
	@RequestMapping(value="/bulk",method=RequestMethod.DELETE)
	public void deleteByUuidAndName(@RequestParam(name="uuid", required=true) String uuid,
			@RequestParam(name="name", required=true) String name) {
		int totalRecordsDeleted = this.empService.bulkDelete(uuid, name);
		System.out.println("records deleted is "+totalRecordsDeleted);
	}
	
	

}
