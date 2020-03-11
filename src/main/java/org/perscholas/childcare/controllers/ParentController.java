package org.perscholas.childcare.controllers;

import java.util.List;

import org.perscholas.childcare.dto.Parent;
import org.perscholas.childcare.services.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("parent")
public class ParentController {
	@Autowired
	ParentService parentService;

	@GetMapping
	public List<Parent> list() {
		return parentService.listParents();
	}
	
	@GetMapping("{id}")
	public Parent get(@PathVariable String id) {
		return parentService.getParent(Integer.parseInt(id));
	}
	
	@PostMapping
	public void add(@RequestBody Parent newParent) {
		parentService.addParent(newParent);
	}

}
