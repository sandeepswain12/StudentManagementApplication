package com.spring.crud.service;

import java.util.List;

import com.spring.crud.dtos.StudentDto;
import com.spring.crud.entity.Student;

public interface StudentService {
	List<StudentDto> getAllStudent();
	
	StudentDto saveStudent(StudentDto studentDto);
	
	StudentDto getStudentById(int id);
	
	StudentDto updateStudent(int id ,StudentDto student);
	
	void deleteStudentById(int id);
}
