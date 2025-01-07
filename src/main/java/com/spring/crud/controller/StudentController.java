package com.spring.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.entity.Student;
import com.spring.crud.repository.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	StudentRepository repo;

	@GetMapping("/students")
	public String getAllStudents(Model model) {
		List<Student> students = repo.findAll();
		model.addAttribute("students",students);
		return "userlist";
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student",student);
		return"userform";
	}
	
	@PostMapping("/student/save")
	public String saveStudent(@ModelAttribute() Student student) {
        repo.save(student);
        return "redirect:/students"; // Redirect to the student list after saving
    }
	
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		return student;
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable int id,Model model){
		Student student = repo.findById(id).get();
		model.addAttribute("student",student);
		return "update.html";
	}
	
	@PostMapping("/student/{id}")
	public String updateStudent(@PathVariable() int id,@ModelAttribute Student student) {
		Student prevstudent = repo.findById(id).get();
		prevstudent.setPercentage(student.getPercentage());
		prevstudent.setBranch(student.getBranch());
		prevstudent.setName(student.getName());
		repo.save(prevstudent);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable int id) {
		repo.deleteById(id);
		return "redirect:/students";
	}

//	@PostMapping("/student/add")
//	@ResponseStatus(code = HttpStatus.CREATED)
//	public void createStudent(@RequestBody Student student) {
//		repo.save(student);
//	}

//	@PutMapping("/student/update/{id}")
//	public Student updateStudent(@PathVariable int id) {
//		Student student = repo.findById(id).get();
//		student.setName("Mohan Majhi");
//		student.setPercentage(50.6f);
//		student.setBranch("BioTech");
//		repo.save(student);
//		return student;
//	}

//	@DeleteMapping("/student/delete/{id}")
//	public void deleteStudent(@PathVariable int id) {
//		Student student = repo.findById(id).get();
//		repo.delete(student);
//	}
}
