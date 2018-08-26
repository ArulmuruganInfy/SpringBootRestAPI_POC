package com.bestBuy.spring.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bestBuy.mongo.repository.EmployeeRepository;
import com.bestBuy.spring.model.Employee;

/**
 * Handles requests for the Employee service.
 */

@RestController
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeRepository empRepo;
	
	@RequestMapping(value = "/rest/emp/getAll", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmployees() {
		logger.info("Controller> getAllEmployee");
		return empRepo.findAll(); 
	}
	
	@RequestMapping(value = "/rest/emp/{id}", method = RequestMethod.GET)
	public @ResponseBody Employee getEmployeeById(@PathVariable("id") String empId) {
		logger.info("Controller> getEmployee with ID="+empId);
		return empRepo.findById(empId).get();
	}
	
	@RequestMapping(value = "/rest/emp/create", method = RequestMethod.POST)
	public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {
		logger.info("Controller> CreateEmployee emp=>"+emp); 
		empRepo.save(emp);
		return emp;
	}
	
	@RequestMapping(value = "/rest/emp/delete/{id}", method = RequestMethod.PUT)
	public void deleteEmployee(@PathVariable("id") String empId) {
		logger.info("Controller> deleteEmployee id="+empId);
		empRepo.delete(new Employee(empId));
	}
	
	@RequestMapping(value = "/rest/randomEndPoint", method = RequestMethod.GET)
	public @ResponseBody String hitRandomEndPoint() throws ClientProtocolException, IOException {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet("http://jsonplaceholder.typicode.com/todos/1");
		HttpResponse response = client.execute(request);
		BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
		String line = "";
		StringBuilder resp=new StringBuilder();
		while ((line = rd.readLine()) != null) {
		    resp.append(line);
		}
		return resp.toString();
	}
}

