package com.best_buy.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.best_buy.spring.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String>{

}
