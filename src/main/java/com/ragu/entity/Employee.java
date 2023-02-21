package com.ragu.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Employee")
public class Employee {

@Column(name = "EMP_ID",nullable = false, length = 512, unique = true)
@Id
private int emp_id;


public int getEmp_id() {
	return emp_id;
}





public void setEmp_id(int emp_id) {
	this.emp_id = emp_id;
}


@Column(name = "NAME", nullable = false)
@NotBlank(message = "Name is Mandatory")
@Pattern(regexp =("[A-Za-z]*"),message = " must be a alphabet")
private String name;

@Column(name = "AGE", nullable = false)
private int age;

@Column(name = "SKILL_SET", nullable = false)
@Size(min = 2, message = "Skill_set should have atleast 2 characters")
@Pattern(regexp =("[A-Za-z]*"),message = "Skill_set must be a alphabet")
private String skill_set;


@Column(name = "LOCATION", nullable = false)
@Size(min = 2, message = "Location should have atleast 2 characters")
@Pattern(regexp =("[A-Za-z]*"),message = "Location must be a alphabet")
private String location;


public Employee() {
	
}





public Employee(int emp_id,String name,int age,String skill_set,String location) {
	super();
	this.emp_id = emp_id;
	this.name = name;
	this.age = age;
	this.skill_set = skill_set;
	this.location = location;
}







public int getAge() {
	return age;
}


public void setAge(int age) {
	this.age = age;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}





public String getSkill_set() {
	return skill_set;
}


public void setSkill_set(String skill_set) {
	this.skill_set = skill_set;
}


public String getLocation() {
	return location;
}


public void setLocation(String location) {
	this.location = location;
}



}
