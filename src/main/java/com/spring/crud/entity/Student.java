package com.spring.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	private String studentId;
	@Column(name = "sname")
	private String name;
	@Column(name = "spercentage")
	private String percentage;
	@Column(name = "sbranch")
	private String branch;
		
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String studentId, String name, String percentage, String branch) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.percentage = percentage;
		this.branch = branch;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	
	
	
}
