package org.perscholas.childcare.controllers;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.perscholas.childcare.dto.Parent;
import org.perscholas.childcare.dto.Student;
import org.perscholas.childcare.services.DailyActivityService;
import org.perscholas.childcare.services.ParentService;
import org.perscholas.childcare.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {

	@Autowired
	StudentService studentService;

	@Autowired
	ParentService parentService;

	@Autowired
	DailyActivityService dailyActivityService;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping({ "/index", "/" })
	public String index() {
		Collection<SimpleGrantedAuthority> authorities =
				(Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext()
						.getAuthentication().getAuthorities();

		Set<String> roles = authorities.stream()
				.map(r -> r.getAuthority()).collect(Collectors.toSet());
		if (roles.contains("ROLE_ADMIN")) {
			return "redirect:/students";
		} else if(roles.contains("ROLE_PARENT")) {
			return "redirect:/students/1";
		}

		return "index";
	}
	

	// show parent registration page
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String viewRegistrationPage(Model model) {
		Parent parentForm = new Parent();
		model.addAttribute("parent", parentForm);
		return "registration";
	}
	
	// add new user
		@RequestMapping(value = "/register", method = RequestMethod.POST)
		public String saveParent(@ModelAttribute("parent") Parent newParent) {
			parentService.addParent(newParent);
			return "successfulRegistration";
		}
	
	//show student registration page
	@RequestMapping(value = "/register_student", method = RequestMethod.GET)
	public String viewStudentRegistrationPage(Model model) {
		Student studentForm = new Student();
		model.addAttribute("student", studentForm);
		return "studentRegistration";
	}

	


	
}
