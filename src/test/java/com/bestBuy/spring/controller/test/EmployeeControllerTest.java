package com.bestBuy.spring.controller.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import com.best_buy.mongo.repository.EmployeeRepository;
import com.best_buy.spring.controller.EmployeeController;
import com.best_buy.spring.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {

	@MockBean
	EmployeeRepository employeeRepo;
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockmvc;
	
	@Configuration

    @EnableAutoConfiguration

    public static class Config {

        @Bean

        public EmployeeController employeeController() {

            return new EmployeeController();

        }

    }
	
	@Before
	public void setup() {
		mockmvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	@Test
	public void  test_getEmployeeById() throws Exception {
		mockmvc.perform(get("/employees/111").accept(MediaType.APPLICATION_JSON))

        .andDo(print())

        .andExpect(status().isOk())

        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
		//mockmvc.perform(get("localhost:8080/employees/124")).andDo(print());
		//Employee e = new Employee("124", "pandi");
		//assertEquals(e.toString(), emp.toString());
	}
}
