package com.ragu.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ragu.entity.Employee;

public interface EmpRepo extends JpaRepository<Employee,Integer> {

	
}
