package com.spring.crud.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.spring.crud.dtos.StudentDto;
import com.spring.crud.service.StudentService;

import jakarta.validation.Valid;

@Controller
public class StudentController {
	
	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	

	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("students",studentService.getAllStudent());
		return "userlist";
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		StudentDto studentDto = new StudentDto();
		model.addAttribute("student",studentDto);
		return"userform";
	}
	
	@PostMapping("/student/save")
	public String saveStudent(@Valid @ModelAttribute() StudentDto studentdto) {
        studentService.create(studentdto);
        return "redirect:/students"; // Redirect to the student list after saving
    }
	
	@GetMapping("/student/{studentId}")
	public StudentDto getStudent(@PathVariable String studentId) {
		StudentDto studentDto = studentService.getStudentById(studentId);
		return studentDto;
	}
	
	@GetMapping("/students/edit/{studentId}")
	public String editStudent(@PathVariable String studentId,Model model){
		model.addAttribute("student",studentService.getStudentById(studentId));
		return "update.html";
	}
	
	@PostMapping("/student/{studentId}")
	public String updateStudent(@PathVariable() String studentId,@Valid @ModelAttribute StudentDto studentDto) {
		studentService.update(studentId,studentDto);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable String studentId) {
		studentService.deleteStudentById(studentId);
		return "redirect:/students";
	}

}
