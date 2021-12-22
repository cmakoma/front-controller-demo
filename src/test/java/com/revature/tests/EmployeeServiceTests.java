package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.dao.EmployeeDAO;
import com.revature.models.Employee;
import com.revature.service.EmployeeService;

public class EmployeeServiceTests {

	
	private EmployeeDAO mockdao;
	private EmployeeService eserv;
	
	
	@Before
	public void setup() {
		
		mockdao = mock(EmployeeDAO.class);
		eserv = new EmployeeService(mockdao);
	}
	
	@After
	public void teardown() {
		mockdao = null;
		eserv = null;
	}
	
	@Test
	public void testConfirmLogin_success() {
		
		Employee e1 = new Employee(3,"Scott", "Lang", "Antman", "bugs");
		Employee e2 = new Employee(23,"Clint", "Barton", "Hawkeye", "arrows");
		
		List<Employee> dummyDb = new ArrayList<>();
		dummyDb.add(e1);
		dummyDb.add(e2);
		
		when(mockdao.findAll()).thenReturn(dummyDb);
		
		assertEquals(e2,eserv.confirmLogin("Hawkeye", "arrows"));
	}
	
	
	@Test
	public void testConfirmLogin_fail() {
		
		Employee e1 = new Employee(3,"Scott", "Lang", "Antman", "bugs");
		Employee e2 = new Employee(23,"Clint", "Barton", "Hawkeye", "arrows");
		
		List<Employee> dummyDb = new ArrayList<>();
		dummyDb.add(e1);
		dummyDb.add(e2);
		
		when(mockdao.findAll()).thenReturn(dummyDb);
		
		assertNull(eserv.confirmLogin("Hawkeye", "arrow"));
	}
	

	
}
