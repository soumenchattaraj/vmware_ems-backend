package org.vm.com.serviceimpls;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vm.com.common.EmployeeTypes;
import org.vm.com.dao.EmployeeDao;
import org.vm.com.models.Employee;
import org.vm.com.services.EmployeeServices;

@Service
public class EmployeeServiceImpl implements EmployeeServices {
	
	@Autowired
	EmployeeDao employeeDao;

	
	public Employee getEmployeeById(Integer empid) 
	{
		return employeeDao.getEmployeeById(empid);
	}

	
	public Employee createEmployee(Employee employee) 
	{
		return employeeDao.addEmployee(employee);
	}

	
	public Employee updateEmployeeById(Integer empid, Employee employee) 
	{
		return employeeDao.updateEmployee(empid, employee);
	}

	
	public List<Employee> getAllEmployeesHierarchy(Integer empid) 
	{
		Queue<Integer> queue = new LinkedList<Integer>();
		List<Employee> finallist = new ArrayList<Employee>();
		
		String designation = employeeDao.getEmployeeById(empid).getDesignation();
		
		if(designation.equals(EmployeeTypes.GRADE_D.toString()))
			return null;
		else
		{
			Optional<List<Employee>> response = Optional.ofNullable(employeeDao.getAll());
			if(response.isPresent())
			{
				List<Employee> returnResult = response.get();
				

				 	   returnResult.stream()
								   .filter(x-> x.getReportee()!=null && x.getReportee()==empid)
								   .forEach(i->{
									   				queue.add(i.getEmpId());
									   				finallist.add(i);
								   			   });
				 
				 while(!queue.isEmpty())
				 {
					 Integer tempId = queue.poll();
					 
					 returnResult.stream()
					   			 .filter(x-> x.getReportee()!=null && x.getReportee()==tempId)
					   			 .forEach(i->{
					   				 			queue.add(i.getEmpId());
					   				 			finallist.add(i);
					   			 			});
					 
					 
					 returnResult.stream()
					   			 .filter(x-> x.getReportee()==null && x.getReportee()==tempId)
					   			 .forEach(i->{
					   				 			queue.add(i.getEmpId());
					   				 			finallist.add(i);
					   			 			 });
				 }
				 
				 
			}
		}
		
		 return finallist;	
	}

	
	public List<Employee> getEmployeesAboveTheHierarchy(Integer empid) 
	{
		List<Employee> finallist = new LinkedList<Employee>();
		String designation = employeeDao.getEmployeeById(empid).getDesignation();
		
		if(designation.equals(EmployeeTypes.GRADE_A.toString()))
			return null;
		
		else if(designation.equals(EmployeeTypes.GRADE_B.toString()))
		{
			
			Optional<List<Employee>> response = Optional.ofNullable(employeeDao.getAll());
			
			if(response.isPresent())
			{
				List<Employee> returnResult = response.get();
				
				returnResult.stream()
	   			 			.filter(x-> x.getDesignation().equals(EmployeeTypes.GRADE_B.toString()) || x.getDesignation().equals(EmployeeTypes.GRADE_A.toString()))
	   			 			.forEach(i->{
	   				 						finallist.add(i);
	   			 						});
			}
		}
		
		else if(designation.equals(EmployeeTypes.GRADE_C.toString()))
		{
			
			Optional<List<Employee>> response = Optional.ofNullable(employeeDao.getAll());
			
			if(response.isPresent())
			{
				List<Employee> returnResult = response.get();
				
				returnResult.stream()
	   			 			.filter(x-> x.getDesignation().equals(EmployeeTypes.GRADE_C.toString()) || x.getDesignation().equals(EmployeeTypes.GRADE_B.toString()) || x.getDesignation().equals(EmployeeTypes.GRADE_A.toString()))
	   			 			.forEach(i->{
	   				 						finallist.add(i);
	   			 						});
			}
		}
		
		return finallist;
	}


	public Employee getCommonSuperior(Integer emp1, Integer emp2) 
	{

		Employee employee1 = employeeDao.getEmployeeById(emp1);
		Employee employee2 = employeeDao.getEmployeeById(emp2);
		
		if(employee1.getReportee() == employee2.getReportee())
			return employee1;
		else
		{
			return getCommonReportee(employee1, employee2);
		}
		
	}
	
	public List<Employee> getEmployeesByCriteria(String designation)
	{
		Optional<List<Employee>> response = Optional.ofNullable(employeeDao.getAll());
		if(response.isPresent())
		{
			return response.get()
						   .stream()
						   .filter(x->x.getDesignation().equals(designation))
						   .collect(Collectors.toList());
		}
		
		return null;
	}
	
	public List<Employee> getAllEmployees()
	{
		return employeeDao.getAll();
	}
	
	private Employee getCommonReportee(Employee emp1, Employee emp2)
	{
		if(emp1.getReportee()==emp2.getReportee())
			return emp1;
		
		getCommonReportee(employeeDao.getEmployeeById(emp1.getReportee()),
						  employeeDao.getEmployeeById(emp2.getReportee()));
		
		
		return null;
	}
	
	

}
