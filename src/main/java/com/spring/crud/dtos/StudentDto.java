package com.spring.crud.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class StudentDto {
	
	private int rollNo;
	@NotBlank(message = "Please Provide Your Username")
	private String name;
	
	//@Size(min = 1 , max = 100,message = "Please Provide Correct Percentage")
	@Min(value = 1, message = "Percentage must be at least 1")
    @Max(value = 100, message = "Percentage cannot be more than 100")
	private String percentage;
	
	@NotBlank(message = "Please Provide Your Branch")
	private String branch;
	
	public StudentDto() {
		
	}
	
	public StudentDto(int rollNo, String name, String percentage, String branch) {
		this.rollNo = rollNo;
		this.name = name;
		this.percentage = percentage;
		this.branch = branch;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
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

