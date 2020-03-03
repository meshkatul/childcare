package org.perscholas.childcare.services;


import java.util.List;
import org.perscholas.childcare.db.ClassRoomRepository;
import org.perscholas.childcare.db.StudentRepository;
import org.perscholas.childcare.dto.ClassRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClassRoomService {
	
	@Autowired
	ClassRoomRepository classRepository;
	StudentRepository studentRepository;
	
	public List<ClassRoom> listClassRooms() {
		return classRepository.findAll();
	}
}
