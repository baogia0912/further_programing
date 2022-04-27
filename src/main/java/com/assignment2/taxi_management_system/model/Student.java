package com.assignment2.taxi_management_system.model;

import javax.persistence.*;

@Entity
@Table(name= "student")
public class Student {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	public Student() {
	}
	
	public Student(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
