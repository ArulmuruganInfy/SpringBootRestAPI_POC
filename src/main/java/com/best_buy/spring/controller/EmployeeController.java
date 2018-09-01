package com.best_buy.spring.controller;


import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.best_buy.mongo.repository.EmployeeRepository;
import com.best_buy.spring.model.Employee;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Handles requests for the Employee service.
 */

@Api(value="Employee API", description="Employee Service")
@RestController
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeRepository empRepo;
	
	@ApiOperation(value=" Fetch all employee details")
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmployees() {
		logger.info("Controller> getAllEmployee");
		return empRepo.findAll(); 
	}
	
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	public @ResponseBody Employee getEmployeeById(@PathVariable("id") String empId) throws InterruptedException {
		logger.info("Controller> getEmployee with ID="+empId);
		//Thread t = new Thread();
		//t.sleep(900);
		//t.join();
		return empRepo.findById(empId).get();
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {
		logger.info("Controller> CreateEmployee emp=>"+emp); 
		empRepo.save(emp);
		return emp;
	}
	
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable("id") String empId) {
		logger.info("Controller> deleteEmployee id="+empId);
		
		empRepo.delete(new Employee(empId));
	}
	
	@RequestMapping(value = "/randomEndPoint", method = RequestMethod.GET)
	public @ResponseBody String hitRandomEndPoint() {
		RestTemplate restTemplate = getRestTemplate();
		//Employee emp = restTemplate.getForObject("http://localhost:8080/employees/125", Employee.class);
		
		return restTemplate.getForObject("http://jsonplaceholder.typicode.com/todos/1", String.class);
		//return emp;
	}
	
	private RestTemplate getRestTemplate() {
		HttpComponentsClientHttpRequestFactory reqFactory = new HttpComponentsClientHttpRequestFactory();
		reqFactory.setConnectTimeout(1000);
		reqFactory.setReadTimeout(1000);
		return new RestTemplate(reqFactory);
	}
}

