package com.spring.crud.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.dtos.StudentDto;
import com.spring.crud.entity.Student;
import com.spring.crud.repository.StudentRepository;
import com.spring.crud.service.StudentService;

@Service
public class StudentServiceImple implements StudentService{
	
	@Autowired
	StudentRepository repo;

	@Override
	public List<StudentDto> getAllStudent() {
		List<Student> students = repo.findAll();
		List<StudentDto> studentDtos = students.stream().map(student -> entityToDto(student)).collect(Collectors.toList());
		return studentDtos;
	}

	@Override
	public StudentDto saveStudent(StudentDto studentdto) {
		Student student = dtoToEntity(studentdto);
		Student savedStudent = repo.save(student);
		return entityToDto(savedStudent);
	}

	

	@Override
	public StudentDto getStudentById(int id) {
		Student student = repo.findById(id).get();
		return entityToDto(student);
	}

	@Override
	public StudentDto updateStudent(int id ,StudentDto studentDto) {
		Student student = repo.findById(id).get();
		student.setName(studentDto.getName());
		student.setBranch(studentDto.getBranch());
		student.setPercentage(studentDto.getPercentage());
		Student updatedStudent = repo.save(student);
		return entityToDto(updatedStudent);
	}

	@Override
	public void deleteStudentById(int id) {
		repo.deleteById(id);
	}
	
	
	private StudentDto entityToDto(Student student) {
		StudentDto studentDto = new StudentDto();
		studentDto.setRollNo(student.getRollNo());
		studentDto.setName(student.getName());
		studentDto.setBranch(student.getBranch());
		studentDto.setPercentage(student.getPercentage());
		return studentDto;
	}

	private Student dtoToEntity(StudentDto studentDto) {
		Student student = new Student();
		student.setName(studentDto.getName());
		student.setBranch(studentDto.getBranch());
		student.setPercentage(studentDto.getPercentage());
		return student;
	}

}
