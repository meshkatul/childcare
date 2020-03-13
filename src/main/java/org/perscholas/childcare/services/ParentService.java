package org.perscholas.childcare.services;


import java.util.List;

import org.perscholas.childcare.db.ParentRepository;
import org.perscholas.childcare.dto.Parent;
import org.perscholas.childcare.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParentService {
	@Autowired
	ParentRepository parentRepository;

	@Autowired
	SecurityService securityService;

	@Autowired
	StudentService studentService;
	
	public List<Parent> listParents(){
		return parentRepository.findAll();	
	}
	
	public Parent addParent(Parent newParent) {
		return parentRepository.save(newParent);
	}
	
	public Parent getParent(int ID) {
		Parent parent = parentRepository.findById(ID).get();
		return parent;
	}


	public Student getStudentByParent() {
		String email = securityService.getCurrentUser();
		Parent parent = parentRepository.findByEmail(email);

		Student student =studentService.getStudentByParent(parent);

		return student;
	}


}
