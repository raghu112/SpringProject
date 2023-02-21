package com.ragu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ragu.entity.Employee;
import com.ragu.service.EmpService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/empl")
public class Empcontroller{
	@Autowired
	private EmpService empservice;
	


	@PostMapping("/addEmployee")
	public ResponseEntity<String> addEmployee(@Valid @RequestBody Employee employe) {
		return new ResponseEntity<String>(empservice.create(employe),HttpStatus.CREATED);
	}

	

	@PostMapping("/createEmployees")
	public ResponseEntity<String> addEmployees (@Valid @RequestBody List<Employee> employees) {
		return new ResponseEntity<String>(empservice.createemployees(employees),HttpStatus.CREATED);
		
	}

	@GetMapping("/employee/{emp_id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable int emp_id) {
		Employee singleemploye= empservice.getEmpById(emp_id);
		return new ResponseEntity<Employee>(singleemploye,HttpStatus.OK); 
	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>>getAllEmployee() {
		return new ResponseEntity<List<Employee>>(empservice.getEmps(),HttpStatus.OK) ;
	}
	
	@PutMapping("/updateemployee")
	public ResponseEntity<String> updateEmp(@Valid @RequestBody Employee employe) {
		String updateEmployee =empservice.update(employe);
		return new ResponseEntity<String>(updateEmployee,HttpStatus.OK);
	}

	@DeleteMapping("/employee/{emp_id}")
	public ResponseEntity<String> deleteEmp(@PathVariable int emp_id) {
		empservice.delete(emp_id);
		return new ResponseEntity<String>("Employee has been deleted successfully!",HttpStatus.OK);
	}
	
}