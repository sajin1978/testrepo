package com.examples.testexamples.testexamples.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examples.testexamples.testexamples.entity.Employee;
import com.examples.testexamples.testexamples.dto.CustomerResponse;

public interface EmployeeDao extends JpaRepository<Employee, String> {

	@Transactional
	@Modifying
	public int deleteByUuidAndName(@Param("uuid") String uuid, @Param("name") String name);
	
	@Query("SELECT new com.examples.testexamples.testexamples.dto.CustomerResponse(c.name,a.city) from Employee c JOIN c.address a")
	public List<CustomerResponse> getCustomerInformation();
}
