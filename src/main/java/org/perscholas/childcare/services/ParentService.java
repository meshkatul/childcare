package org.perscholas.childcare.services;


import java.util.List;

import org.perscholas.childcare.db.ParentRepository;
import org.perscholas.childcare.dto.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParentService {
	@Autowired
	ParentRepository parentRepository;
	
	public List<Parent> listParents(){
		return parentRepository.findAll();	
	}
	
	public void addParent(Parent newParent) {
		parentRepository.save(newParent);
	}
	
	public Parent getParent(int ID) {
		Parent parent = parentRepository.findById(ID).get();
		return parent;
	}

}
