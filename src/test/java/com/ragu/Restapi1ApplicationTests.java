
package com.ragu; 
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals; 
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List; 
import org.junit.jupiter.api.MethodOrderer; 
import org.junit.jupiter.api.Order; 
import org.junit.jupiter.api.Test; 
import org.junit.jupiter.api.TestMethodOrder; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest; 
import org.springframework.test.annotation.Rollback;

import com.ragu.dao.EmpRepo; import com.ragu.entity.Employee;


@DataJpaTest 
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) 
class Restapi1ApplicationTests {

	@Autowired 
	private EmpRepo emp;

	//unit testing

	@Test
	@Order(1)
	@Rollback(value=false) public void postEmpTest() { 
		Employee empo = new Employee(); 
		empo.setEmp_id(20); 
		empo.setAge(21); 
		empo.setName("Ragavendran");
		empo.setLocation("Banglore");
		empo.setSkill_set("Java"); 
		emp.save(empo);
		assertNotNull(emp.findById(20).get());

	}

	@Test
	@Order(2) 
	public void getEmpTest() { 
		Employee empo= emp.findById(20).get();
		assertThat(empo.getEmp_id()).isEqualTo(20); 
	}

	@Test
	@Order(3) 
	public void getEmpTestAll () { 
		List<Employee> list=emp.findAll();
		assertThat(list.size()).isGreaterThan(0); 
	}


	@Test
	@Order(4) 
	@Rollback(value=false) 
	public void updateEmpTest() { 
		Employee empo =emp.findById(20).get(); 
		empo.setAge(30); emp.save(empo); 
		assertNotEquals(21,emp.findById(20).get().getAge()); 

	}

	@Test
	@Order(5)
	@Rollback(value=false) 
	public void deleteEmpTest() 
	{
		emp.deleteById(20);
		assertThat(emp.existsById(20)).isFalse(); }

}
