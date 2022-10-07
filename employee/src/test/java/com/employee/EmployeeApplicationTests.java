package com.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class EmployeeApplicationTests {
	@Autowired
	private EmployeeService employeeService;

	@Test
	public void add() {
		Employee e = new Employee();
		e.setEmpId(1);
		e.setFirstName("Vinayak");
		e.setLastName("Pujari");
		e.setEmail("vnk123@gmail.com");
		employeeService.save(e);
		Employee e1=employeeService.getEmpById(e.getEmpId());
		assertNotNull(e1);
	}
	@Test
	public void get() {
		Employee e=new Employee();
		e.setEmpId(11);
		e.setFirstName("prachi");
		e.setLastName("tayade");
		e.setEmail("prachi123@gmail.com");
		employeeService.save(e);
		Employee e1=employeeService.getEmpById(e.getEmpId());
		assertEquals("prachi123@gmail.com",e1.getEmail());
	}
	@Test
	public void getAll() {
		List list=employeeService.getAllEmp();
		assertNotEquals(0, list.size());
	}
	@Test
	public void delete() {
		Employee e = new Employee();
		e.setEmpId(111);
		e.setFirstName("Shubham");
		e.setLastName("Pol");
		e.setEmail("Shubham123@gmail.com");
		employeeService.save(e);
		employeeService.delete(111L);
		Employee e1=employeeService.getEmpById(111L);
		assertEquals(false,e1.isPresent());
	}
	@Test
	public void update() {
		Employee u=new Employee();
		u.setEmpId(222);
		u.setFirstName("Shrey");
		u.setLastName("Jamdar");
		u.setEmail("shrey23@gmail.com");
		employeeService.save(u);
		u.setFirstName("omkar");
		employeeService.update(u);
		assertEquals("omkar",u.getFirstName());

	}

}
