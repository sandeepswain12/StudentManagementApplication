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
        studentService.saveStudent(studentdto);
        return "redirect:/students"; // Redirect to the student list after saving
    }
	
	@GetMapping("/student/{id}")
	public StudentDto getStudent(@PathVariable int id) {
		StudentDto studentDto = studentService.getStudentById(id);
		return studentDto;
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable int id,Model model){
		model.addAttribute("student",studentService.getStudentById(id));
		return "update.html";
	}
	
	@PostMapping("/student/{id}")
	public String updateStudent(@PathVariable() int id,@Valid @ModelAttribute StudentDto studentDto) {
		studentService.updateStudent(id,studentDto);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}

}
