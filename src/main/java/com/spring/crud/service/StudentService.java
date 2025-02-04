package com.spring.crud.service;

import java.util.List;

import com.spring.crud.dtos.StudentDto;
import com.spring.crud.entity.Student;

public interface StudentService {
	
	//create
	StudentDto create(StudentDto studentDto);
	
	//update
	StudentDto update(String studentId ,StudentDto studentDto);
	
	//delete
	void deleteStudentById(String studentId);
	
	//getAll
	List<StudentDto> getAllStudent();
	
	//getById
	StudentDto getStudentById(String studentId);	
	
}
