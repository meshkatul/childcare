package org.perscholas.childcare.controllers;

import java.io.FileNotFoundException;
import java.util.List;

import org.perscholas.childcare.dto.Student;
import org.perscholas.childcare.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("students")
public class StudentController {
	@Autowired
	StudentService studentService;

	@GetMapping
	public List<Student> list() throws FileNotFoundException {
		return studentService.listStudents();
	}
	
	
	@GetMapping("{id}")
	public Student get(@PathVariable String id) throws FileNotFoundException {
		return studentService.getStudent(Integer.parseInt(id));
	}	
}
