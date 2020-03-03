package org.perscholas.childcare.controllers;

import java.io.FileNotFoundException;
import java.util.List;

import org.perscholas.childcare.dto.ClassRoom;
import org.perscholas.childcare.dto.Student;
import org.perscholas.childcare.services.ClassRoomService;
import org.perscholas.childcare.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("classrooms")
public class ClassRoomController {
	@Autowired
	ClassRoomService classRoomService;
	
	@Autowired
	StudentService studentService;
	
	@GetMapping
	public List<ClassRoom> list() throws FileNotFoundException{
		return classRoomService.listClassRooms();
	}
	
	@GetMapping("{id}/students")
	public List<Student> getStudentsByClass(@PathVariable String id) throws FileNotFoundException {
		return studentService.listStudentsByClass(Integer.parseInt(id));
	}

}
