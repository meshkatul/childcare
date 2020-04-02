package org.perscholas.childcare.controllers;

import org.perscholas.childcare.dto.Parent;
import org.perscholas.childcare.dto.Student;
import org.perscholas.childcare.services.ParentService;
import org.perscholas.childcare.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("parent")
public class ParentController {
	@Autowired
	ParentService parentService;

	@Autowired
	StudentService studentService;

	//view parent registration page
	@RequestMapping
	public String viewRegistrationPage(Model model) {
		Parent parentForm = new Parent();
		model.addAttribute("parent", parentForm);
		return "parentRegistration";
	}

	//register parent and go to student registration page
	@RequestMapping(method = RequestMethod.POST)
	public String saveParent(@ModelAttribute("parent") Parent newParent) {
		Parent savedParent = parentService.addParent(newParent);
		return "redirect:/parent/" + savedParent.getParentId() + "/student";
	}


	//show student registration page with parent info
	@RequestMapping(value = "/{parentId}/student", method = RequestMethod.GET)
	public String viewStudentRegistrationPage(@PathVariable("parentId") int parentId, Model model) {
		Student studentForm = new Student();
		Parent parent = parentService.getParent(parentId);
		studentForm.setParent(parent);
		model.addAttribute("student", studentForm);
		return "studentRegistration";
	}

	// add new student
	@RequestMapping(value = "/{parentId}/student", method = RequestMethod.POST)
	public String saveStudent(@PathVariable("parentId") int parentId, @ModelAttribute("student") Student newStudent) {
		studentService.addStudent(newStudent);
		return "redirect:/students";
	}

}
