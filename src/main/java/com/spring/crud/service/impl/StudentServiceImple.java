package com.spring.crud.service.impl;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.dtos.StudentDto;
import com.spring.crud.entity.Student;
import com.spring.crud.exceptions.ResourceNotFoundException;
import com.spring.crud.repository.StudentRepository;
import com.spring.crud.service.StudentService;

@Service
public class StudentServiceImple implements StudentService {

	@Autowired
	StudentRepository repo;

	@Autowired
	ModelMapper mapper;

	@Override
	public StudentDto create(StudentDto studentDto) {
		Random random = new Random();
		String studentId = String.valueOf(1000000000L + (long) (random.nextDouble() * 9000000000L));
		studentDto.setStudentId(studentId);
		Student student = mapper.map(studentDto, Student.class);
		Student savedStudent = repo.save(student);
		return mapper.map(savedStudent, StudentDto.class);
	}

	@Override
	public StudentDto update(String studentId, StudentDto studentDto) {
		Student student = repo.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("student not found with this "+studentId+" id"));
		student.setName(studentDto.getName());
		student.setBranch(studentDto.getBranch());
		student.setPercentage(studentDto.getPercentage());
		Student updatedStudent = repo.save(student);
		return mapper.map(updatedStudent, StudentDto.class);
	}

	@Override
	public void deleteStudentById(String studentId) {
		Student student = repo.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("student not found with this "+studentId+" id"));
		repo.delete(student);
	}

	@Override
	public List<StudentDto> getAllStudent() {
		List<Student> students = repo.findAll();
		List<StudentDto> studentDtos = students.stream().map(student -> mapper.map(student,StudentDto.class)).collect(Collectors.toList());
		return studentDtos;
	}

	@Override
	public StudentDto getStudentById(String studentId) {
		Student student = repo.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("student not found with this "+studentId+" id"));
		return mapper.map(student, StudentDto.class);
	}

//	@Override
//	public List<StudentDto> getAllStudent() {
//		List<Student> students = repo.findAll();
//		List<StudentDto> studentDtos = students.stream().map(student -> entityToDto(student)).collect(Collectors.toList());
//		return studentDtos;
//	}
//
//	@Override
//	public StudentDto saveStudent(StudentDto studentdto) {
//		Random random = new Random();
//        String studentId = String.valueOf(1000000000L + (long)(random.nextDouble() * 9000000000L));
//        studentdto.setRollNo(studentId);
//		Student student = dtoToEntity(studentdto);
//		Student savedStudent = repo.save(student);
//		return entityToDto(savedStudent);
//	}
//
//	
//
//	@Override
//	public StudentDto getStudentById(int id) {
//		Student student = repo.findById(id).get();
//		return entityToDto(student);
//	}
//
//	@Override
//	public StudentDto updateStudent(int id ,StudentDto studentDto) {
//		Student student = repo.findById(id).get();
//		student.setName(studentDto.getName());
//		student.setBranch(studentDto.getBranch());
//		student.setPercentage(studentDto.getPercentage());
//		Student updatedStudent = repo.save(student);
//		return entityToDto(updatedStudent);
//	}
//
//	@Override
//	public void deleteStudentById(int id) {
//		repo.deleteById(id);
//	}
//	
//	
//	private StudentDto entityToDto(Student student) {
//		StudentDto studentDto = new StudentDto();
//		studentDto.setRollNo(student.getRollNo());
//		studentDto.setName(student.getName());
//		studentDto.setBranch(student.getBranch());
//		studentDto.setPercentage(student.getPercentage());
//		return studentDto;
//	}
//
//	private Student dtoToEntity(StudentDto studentDto) {
//		Student student = new Student();
//		student.setRollNo(studentDto.getRollNo());
//		student.setName(studentDto.getName());
//		student.setBranch(studentDto.getBranch());
//		student.setPercentage(studentDto.getPercentage());
//		return student;
//	}

}
