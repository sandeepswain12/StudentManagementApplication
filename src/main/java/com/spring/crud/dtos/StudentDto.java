package com.spring.crud.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class StudentDto {
	
	private String studentId;
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

	public StudentDto(String studentId, @NotBlank(message = "Please Provide Your Username") String name,
			@Min(value = 1, message = "Percentage must be at least 1") @Max(value = 100, message = "Percentage cannot be more than 100") String percentage,
			@NotBlank(message = "Please Provide Your Branch") String branch) {
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

