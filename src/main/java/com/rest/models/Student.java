package com.rest.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	private String student_name;
	
	@Column(nullable = false)
	@Min(value = 6, message = "The student must be above 6 years of age.")
	@Max(value = 28, message = "The student must be under 28 years of age.")
	private int age;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private int total_marks;
	
	Student(){};

	// Contructor with all fields
	public Student(int id, String student_name, int age, String city, int total_marks) {
		super();
		this.id = id;
		this.student_name = student_name;
		this.age = age;
		this.city = city;
		this.total_marks = total_marks;
	}

	// Getter, Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getTotal_marks() {
		return total_marks;
	}

	public void setTotal_marks(int total_marks) {
		this.total_marks = total_marks;
	}
	
}
