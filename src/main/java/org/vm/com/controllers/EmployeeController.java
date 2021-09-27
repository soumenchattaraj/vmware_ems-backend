package org.vm.com.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vm.com.models.Employee;
import org.vm.com.models.ResponseBody;
import org.vm.com.services.EmployeeServices;

import com.google.gson.Gson;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/employee")
@Api(description = "Employee Management API's")
public class EmployeeController {
	
	@Autowired
	EmployeeServices employeeServices;
	
	Gson gson = new Gson();
	
	
	@CrossOrigin("*")
	@RequestMapping(value="/employees/{empid}",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public String getEmployeeById(@PathVariable("empid")Integer empid)
	{
		
		Optional<Employee> response = Optional.ofNullable(employeeServices.getEmployeeById(empid));
		if(response.isPresent())
			return gson.toJson(new ResponseBody("success",HttpStatus.OK, Arrays.asList(response)));

		
		return gson.toJson(new ResponseBody("success! no data found",HttpStatus.OK, Arrays.asList()));
		
	}
	
	
	@CrossOrigin("*")
	@RequestMapping(value="/employees",
					method = RequestMethod.POST,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public String createEmployee(@RequestBody Employee employee)
	{
		
		Optional<Employee> response = Optional.ofNullable(employeeServices.createEmployee(employee));
		if(response.isPresent())
			return gson.toJson(new ResponseBody("success",HttpStatus.OK, Arrays.asList(response)));
		
		return gson.toJson(new ResponseBody("success! no data found",HttpStatus.OK, Arrays.asList()));
	}
	
	
	
	@CrossOrigin("*")
	@RequestMapping(value="/employees/{empid}",
					method = RequestMethod.PUT,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateEmployeeById(@PathVariable("empid")Integer empid,
									 @RequestBody Employee employee)
	{
		Optional<Employee> response = Optional.ofNullable(employeeServices.updateEmployeeById(empid,employee));
		if(response.isPresent())
			return gson.toJson(new ResponseBody("success",HttpStatus.OK, Arrays.asList(response)));
		
		return gson.toJson(new ResponseBody("success! no data found",HttpStatus.OK, Arrays.asList()));
	}
	
	
	
	@CrossOrigin("*")
	@RequestMapping(value="/employees",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public String getEmployeesByCriteria(@RequestParam("designation")String designation)
	{
		Optional<List<Employee>> response = Optional.ofNullable(employeeServices.getEmployeesByCriteria(designation));
		if(response.isPresent())
			return gson.toJson(new ResponseBody("success",HttpStatus.OK, Arrays.asList(response)));
		
		return gson.toJson(new ResponseBody("success! no data found",HttpStatus.OK, Arrays.asList()));
	}
	
	
	
	@CrossOrigin("*")
	@RequestMapping(value="/employees/{empId}/reportees",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAllEmployeesHierarchy(@PathVariable("empid")Integer empid)
	{
		Optional<List<Employee>> response = Optional.ofNullable(employeeServices.getAllEmployeesHierarchy(empid));
		if(response.isPresent())
			return gson.toJson(new ResponseBody("success",HttpStatus.OK, Arrays.asList(response)));
		
		return gson.toJson(new ResponseBody("success! no data found",HttpStatus.OK, Arrays.asList()));
	}
	
	
	
	@CrossOrigin("*")
	@RequestMapping(value="/employees/{empId}/managers",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public String getEmployeesAboveTheHierarchy(@PathVariable("empid")Integer empid)
	{
		Optional<List<Employee>> response = Optional.ofNullable(employeeServices.getEmployeesAboveTheHierarchy(empid));
		if(response.isPresent())
			return gson.toJson(new ResponseBody("success",HttpStatus.OK, Arrays.asList(response)));
		
		return gson.toJson(new ResponseBody("success! no data found",HttpStatus.OK, Arrays.asList()));
	}
	
	
	
	@CrossOrigin("*")
	@RequestMapping(value="/employees/commonsuperior",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public String getCommonSuperior(@RequestParam("emp1")Integer emp1,@RequestParam("emp2")Integer emp2)
	{
		Optional<Employee> response = Optional.ofNullable(employeeServices.getCommonSuperior(emp1,emp2));
		if(response.isPresent())
			return gson.toJson(new ResponseBody("success",HttpStatus.OK, Arrays.asList(response)));
		else
			return gson.toJson(new ResponseBody("success! no data found",HttpStatus.OK, Arrays.asList()));
	}

	@CrossOrigin("*")
	@RequestMapping(value="/all",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAllEmployees()
	{
		Optional<List<Employee>> response = Optional.ofNullable(employeeServices.getAllEmployees());
		if(response.isPresent())
			return gson.toJson(new ResponseBody("success",HttpStatus.OK, response.get()));
		else
			return gson.toJson(new ResponseBody("success! no data found",HttpStatus.OK, Arrays.asList()));
	}
	

}
