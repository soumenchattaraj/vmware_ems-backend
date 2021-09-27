package org.vm.com.services;

import java.util.List;

import org.vm.com.models.Employee;

public interface EmployeeServices {
	
	public Employee getEmployeeById(Integer empid);
	public Employee createEmployee(Employee employee);
	public Employee updateEmployeeById(Integer empid,Employee employee);
	public List<Employee> getAllEmployeesHierarchy(Integer empid);
	public List<Employee> getEmployeesAboveTheHierarchy(Integer empid);
	public Employee getCommonSuperior(Integer emp1,Integer emp2);
	public List<Employee> getEmployeesByCriteria(String designation);
	public List<Employee> getAllEmployees();
	

}
