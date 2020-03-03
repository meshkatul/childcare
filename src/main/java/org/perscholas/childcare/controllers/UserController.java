package org.perscholas.childcare.controllers;

import java.io.FileNotFoundException;
import java.util.List;
import org.perscholas.childcare.dto.User;
import org.perscholas.childcare.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping
	public List<User> list() throws FileNotFoundException {
		return userService.listUsers();
	}
	
	@GetMapping("{id}")
	public User get(@PathVariable String id) throws FileNotFoundException {
		return userService.getUser(Integer.parseInt(id));
	}
	
	@PostMapping
	public void add(@RequestBody User newUser) throws FileNotFoundException {
		userService.addUser(newUser);
	}

}
