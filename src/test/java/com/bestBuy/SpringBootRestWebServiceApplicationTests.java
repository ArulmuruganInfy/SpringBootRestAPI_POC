package com.bestBuy;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.best_buy.spring.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRestWebServiceApplicationTests {

	TestRestTemplate testRestTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	@Test
	public void  getEmployeeByIdTest() {
		HttpEntity<String> entity = new HttpEntity<>(null,headers);
		Employee emp = testRestTemplate.getForObject("http://localhost:8080/employees/124", Employee.class);
		Employee e = new Employee("124", "pandi");
		assertEquals(e.toString(), emp.toString());
	}
}
