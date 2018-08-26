package com.bestBuy.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bestBuy.spring.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String>{

}
