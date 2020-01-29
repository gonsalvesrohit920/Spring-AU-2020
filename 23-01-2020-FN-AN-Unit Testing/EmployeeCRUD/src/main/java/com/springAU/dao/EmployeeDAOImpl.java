package com.springAU.dao;


import java.util.List;

import com.springAU.model.Employee;
import java.sql.ResultSet;

 
import javax.sql.DataSource;
 

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	

	public EmployeeDAOImpl() {
		super();
	}

	public EmployeeDAOImpl(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean saveOrUpdate(Employee employee) {
		boolean response = false;
		try {
			if(employee.getId() != 0) {
				
				String query = "update Employee set firstName=?, lastName=?, contact=? where id=?";
				jdbcTemplate.update(query,employee.getFirstName(),employee.getLastName(),employee.getContact(),employee.getId());
				
				}
			else {
				String query = "insert into Employee (firstName,lastname,contact) values(?,?,?)";
				jdbcTemplate.update(query,employee.getFirstName(),employee.getLastName(),employee.getContact());
			}
		
		 	response = true;
			}
		catch(Exception e)
		{
			response = false;
		}
		
			
		return response;
		

	}

	public boolean deletById(int Id) {
		// TODO Auto-generated method stub
		boolean response = false;
		try {
				String query = "delete from employee where id=?";
				jdbcTemplate.update(query, Id);    
				response = true;
			}
			catch(Exception e)
			{
				response = false;
			}
			
				
			return response;
			
	}

	public Employee findById(int Id) {
		
		String query = "select * from Employee where id=" + Id;
		
		return jdbcTemplate.query(query, (ResultSet rs) -> {
			if(rs.next()) {
				Employee employee = new Employee(rs.getInt("id"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("contact"));
				
				return employee;
			}
			else {
				return null;
			}
		});
	
	}

	public List<Employee> fetchAll() {
		// TODO Auto-generated method stub
		// = new ArrayList<Employee>();
		
		String query = "select * from Employee";
		
		List<Employee> empList = jdbcTemplate.query(query, (ResultSet rs, int rowNum) ->{
			
			Employee employee = new Employee(rs.getInt("id"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("contact"));
			
			return employee;
			
		});
		
		
		return empList;
	}

}
