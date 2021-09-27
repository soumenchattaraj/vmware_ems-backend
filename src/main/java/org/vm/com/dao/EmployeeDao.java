package org.vm.com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.vm.com.models.Employee;

@Repository
public class EmployeeDao {
	
	private Map<Integer,Employee> empInMemoryDatabase = new HashMap<>();
	
	
	public Employee addEmployee(Employee employee)
	{
		if(!empInMemoryDatabase.containsKey(employee.getEmpId()))
		{
			employee.setId(employee.getEmpId());
			empInMemoryDatabase.put(employee.getEmpId(), employee);
			return employee;
		}
		
		return null;
	
	}
	
	public Employee getEmployeeById(Integer empId)
	{
		if(empInMemoryDatabase.containsKey(empId))
			return empInMemoryDatabase.get(empId);
		
		return null;
	}
	
	public Employee updateEmployee(Integer empId,Employee employee)
	{
		if(empInMemoryDatabase.containsKey(empId))
		{
			String generatedEmployeeId =  empInMemoryDatabase.get(empId).getEmailId();
				   employee.setEmailId(generatedEmployeeId);
				   
			 empInMemoryDatabase.put(empId,employee);
			 
			 return employee;
		}
		
		return null;
	}
	
	
	public Employee deleteEmployee(Integer empId)
	{
		if(empInMemoryDatabase.containsKey(empId))
		{
			Employee employee = new Employee();
					 employee = empInMemoryDatabase.get(empId);
					 
					 
				
			empInMemoryDatabase.remove(empId);
			
			return employee;
		}
		
		return null;
	}
	
	public List<Employee> getAll()
	{
		return empInMemoryDatabase.entrySet()
								  .stream()
								  .map(e -> e.getValue())
								  .collect(Collectors.toList());
	}

	
}
