package com.bestBuy.spring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Employee")
public class Employee{

	@Id
	private String id;
	private String name;
		
	
	public Employee() {
		super();
	}
	public Employee(String id) {
		super();
		this.id = id;
	}
	public Employee(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "id="+id+",name="+name;
	}
}
