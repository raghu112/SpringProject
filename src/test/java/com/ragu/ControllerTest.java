package com.ragu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ragu.controller.Empcontroller;
import com.ragu.entity.Employee;
import com.ragu.service.EmpService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) 
@SpringBootTest(classes= {ControllerTest.class})
public class ControllerTest {
	
	@Mock
	EmpService empservice;
	
	@InjectMocks
	Empcontroller empcontroller; 
	
	List<Employee> myemployee;
	Employee employee;
	
	
	@Test
	@Order(1)
	public void getAllEmployees() {
		myemployee=new ArrayList<Employee>();
		myemployee.add(new Employee(1,"Raghunandhan",20,"Java","Chennai"));
		myemployee.add(new Employee(2,"Banglore",30,"Nithin","Node_js"));
		when(empservice.getEmps()).thenReturn(myemployee);
		ResponseEntity<List<Employee>> res =empcontroller.getAllEmployee();
		assertEquals(HttpStatus.OK,res.getStatusCode());
		assertEquals(2,res.getBody().size());
		
	}
	
	@Order(2)
	@Test
	public void getEmployeById() {
		employee=new Employee(3,"Azar",20,"Java","Chennai");
		int emp_id=3;
		when(empservice.getEmpById(emp_id)).thenReturn(employee);
		ResponseEntity<Employee> res =empcontroller.getEmpById(emp_id);
		assertEquals(HttpStatus.OK,res.getStatusCode());
		assertEquals(emp_id,res.getBody().getEmp_id());
	}
	
	@Order(3)
	@Test
	public void createemployee() {
		employee=new Employee(4,"Guru",20,"Ruby","Mysore");
		when(empservice.create(employee)).thenReturn("RECORD CREATED");
		ResponseEntity<String> res=empcontroller.addEmployee(employee);
		assertEquals(HttpStatus.CREATED,res.getStatusCode());
		assertEquals("RECORD CREATED",res.getBody());
		
	}
	
	
	@Order(4)
	@Test
	public void createemployees() {
		myemployee=new ArrayList<Employee>();
	    myemployee.add(new Employee(5,"Arjun",21,"C#","Hyderabad"));
		myemployee.add(new Employee(6,"Keerthi",22,".NET","Mumbai"));
		when(empservice.createemployees(myemployee)).thenReturn("RECORD CREATED");
		ResponseEntity<String> res=empcontroller.addEmployees(myemployee);
		assertEquals(HttpStatus.CREATED,res.getStatusCode());
	}
	
	
	
	@Order(5)
	@Test
	public void updateEmployee() {
		employee=new Employee(7,"Raghul",22,".NET","Mumbai");
		employee=new Employee(7,"Rakesh",29,".NET","Mumbai");
		when(empservice.update(employee)).thenReturn("RECORD HAS BEEN UPDATED");
		ResponseEntity<String> res=empcontroller.updateEmp(employee);
		assertEquals(HttpStatus.OK,res.getStatusCode());
	}
	
	@Order(6)
	@Test
	public void deleteEmployee() {
		employee=new Employee(7,"Raghul",22,".NET","Mumbai");
		int emp_id=7;
		when(empservice.delete(emp_id)).thenReturn("Employee has been deleted successfully!");
		ResponseEntity<String> res=empcontroller.deleteEmp(emp_id);
		assertEquals(HttpStatus.OK,res.getStatusCode());
	}

}
