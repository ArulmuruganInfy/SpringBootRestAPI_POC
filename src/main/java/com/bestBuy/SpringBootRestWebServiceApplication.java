package com.bestBuy;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bestBuy.mongo.repository.EmployeeRepository;
import com.bestBuy.spring.model.Employee;

@SpringBootApplication
public class SpringBootRestWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestWebServiceApplication.class, args);
	}
	@Bean 
    CommandLineRunner init (EmployeeRepository empRepo){
        return args -> {
            List<Employee> emps = Arrays.asList(new Employee("123","Arul"), new Employee("124","pandi"), new Employee("125","Sangeetha"), new Employee("126","Alagar"));
            emps.forEach(emp -> empRepo.save(emp));
        };
    }
}
