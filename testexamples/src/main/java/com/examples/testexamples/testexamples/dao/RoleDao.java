package com.examples.testexamples.testexamples.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examples.testexamples.testexamples.entity.Role;

public interface RoleDao extends JpaRepository<Role, String> {

}
