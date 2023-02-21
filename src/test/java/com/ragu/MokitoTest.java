
package com.ragu;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ragu.dao.EmpRepo;
import com.ragu.entity.Employee;
import com.ragu.service.EmpService;

@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) 

@SpringBootTest(classes= {MokitoTest.class}) 
class MokitoTest {

	@InjectMocks
	private EmpService empservice;

	@Mock 
	private EmpRepo emp;
	
	public Employee myemployee;

	@Test 
	@Order(1)
	public void test_getallemployee() { 
		List<Employee>myemployee=new ArrayList<Employee>();
		myemployee.add(new Employee(1,"Raghunandhan",20,"Java","Chennai"));
		myemployee.add(new Employee(2,"Banglore",30,"Nithin","Node_js"));
		when(emp.findAll()).thenReturn(myemployee);     //MOCKING
		assertEquals(2,empservice.getEmps().size());	
	}
	
	
	@Test
	@Order(2)
	public void test_addEmployee() {
		Employee employee =new Employee(3,"Siva",30,"Java","Madurai");
//		when(emp.save(employee)).thenReturn(employee);   //MOCKING
		assertEquals("RECORD CREATED", empservice.create(employee));
	}
	
	@Test
	@Order(3)
	public void test_getEmployeeById() {
		Employee myemployee =new Employee();
		myemployee.setEmp_id(30);
		when(emp.findById(myemployee.getEmp_id())).thenReturn(Optional.of(myemployee)); //MOCKING
		Employee expected =empservice.getEmpById(myemployee.getEmp_id());
		assertThat(expected).isSameAs(myemployee);
      }
	
	@Test
	@Order(4)
	public void test_updateEmployee() {
		Employee employe =new Employee(3,"ragu",30,"Java","Madurai");
		when(emp.save(employe)).thenReturn(employe);     //MOCKING
		assertEquals("RECORD HAS BEEN UPDATED",empservice.update(employe));
	}
	
	@Test
	@Order(5)
	public void test_deleteEmployee() {
		Employee employ =new Employee(3,"ragu",30,"Java","Madurai");
		when(emp.findById(employ.getEmp_id())).thenReturn(Optional.of(employ));
		assertEquals("EMPLOYEE GOT DELETED",empservice.delete(employ.getEmp_id()));
	}
}












































