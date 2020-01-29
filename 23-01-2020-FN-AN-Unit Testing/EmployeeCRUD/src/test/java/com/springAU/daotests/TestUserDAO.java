package com.springAU.daotests;
	
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.springAU.dao.EmployeeDAO;
import com.springAU.model.Employee;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class TestUserDAO {
	
	@Mock
	EmployeeDAO employeeDAO;
	
	@Mock
	DataSource dataSource;
	
	@Mock
	Connection connection;
	
	@Mock
	PreparedStatement preparedStatement;
	
	@Mock
	ResultSet resultSet;
	
	@Mock
	Employee employee;
	
	private Employee emp1 = new Employee(1,"Rohit","Gonsalves","7057911333");
	private Employee emp2;
	
	private List<Employee> employees = new ArrayList<>();
	
	@Test
	public void testEmployeeDAO() throws SQLException{
		
		this.employees.add(new Employee(2, "Omkar", "Raykar", "1234567890"));
		this.employees.add(new Employee(3, "Darshan", "Patil", "8448103420"));
		
		Mockito.doAnswer(invocation -> {
			emp2 = (Employee)invocation;
			Assert.assertEquals(emp2.getFirstName(), "Rohit"); //Test insert Functionality and check for Name as Rohit
			
			Assert.assertNotNull(emp2.getId());
			return null;
		}).when(employeeDAO).saveOrUpdate(employee);
		
		
		Mockito.doAnswer(invocation -> {
			Employee dummy = (Employee)invocation; // Test Update Functionality and check for presence of Id 2 in the Employee list 
			Assert.assertEquals(dummy.getId(), 2);
			
			return null;
		}).when(employeeDAO).saveOrUpdate(employee);
		
		
		Mockito.doAnswer(invocation -> {
			
			Employee tempEmployee = (Employee) invocation;
			Assert.assertFalse(tempEmployee.getId() == 0); //Test Delete Functionality and check for missing ID
			
			return null;
		}).when(employeeDAO).deletById(2);
		
		
		when(employeeDAO.findById(1)).thenReturn(this.emp1);
		
		when(employeeDAO.fetchAll()).thenReturn(this.employees);
		
		
		//Run and examine all the tests
		
		employeeDAO.saveOrUpdate(new Employee(4,"Rohan","Pawar","7234564444"));
		employeeDAO.saveOrUpdate(new Employee(2,"Rohan","Pawar","7234564444"));
		employeeDAO.findById(2);
		Assert.assertEquals(employeeDAO.fetchAll().size(), 2);
		
	}
	
}
	