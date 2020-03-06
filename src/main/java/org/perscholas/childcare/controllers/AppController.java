package org.perscholas.childcare.controllers;

import java.util.List;

import org.perscholas.childcare.dto.LoginForm;
import org.perscholas.childcare.dto.Student;
import org.perscholas.childcare.dto.User;
import org.perscholas.childcare.services.DailyActivityService;
import org.perscholas.childcare.services.StudentService;
import org.perscholas.childcare.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
	UserService userService;

	@Autowired
	DailyActivityService dailyActivityService;
	
	// show student page
	@RequestMapping("/")
	public String viewStudentPage(Model model) {
		List<Student> listStudent = studentService.listStudents();
		//System.out.println("StudentListSize: " + listStudent.size());
		model.addAttribute("listStudent", listStudent);
		return "student";
	}

	// show registration page
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String viewRegistrationPage(Model model) {
		User userForm = new User();
		model.addAttribute("user", userForm);
		return "registration";
	}

	// add new user
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User newUser) {
		userService.addUser(newUser);
		return "redirect://registerSuccessful";
	}

	

	// show register successful page
	@RequestMapping("/registerSuccessful")
	public String viewRegisterSuccessful(Model model) {
		return "successfulRegistration";
	}

	// show login page
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginForm() {
		return "login";
	}

	// validation
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
		User user = new User();
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();

		if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
			return "registration";
		}

		model.addAttribute("invalidCredentials", true);
		return "registration";

	}

	/*
	 * @RequestMapping(value = "/registration", method = RequestMethod.GET) public
	 * String viewRegistrationPage(Model model) { List<User> listUser =
	 * userService.listUsers(); model.addAttribute("listUser", listUser); return
	 * "registration"; }
	 */
}
