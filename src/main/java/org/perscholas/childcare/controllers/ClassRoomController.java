package org.perscholas.childcare.controllers;


import java.util.List;

import org.perscholas.childcare.dto.ClassRoom;
import org.perscholas.childcare.services.ClassRoomService;
import org.perscholas.childcare.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<ClassRoom> list() {
		return classRoomService.listClassRooms();
	}
	
	
	
	
}
