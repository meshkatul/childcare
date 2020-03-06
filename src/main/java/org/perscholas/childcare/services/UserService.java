package org.perscholas.childcare.services;


import java.util.List;
import org.perscholas.childcare.db.UserRepository;
import org.perscholas.childcare.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public List<User> listUsers(){
		return userRepository.findAll();	
	}
	
	public void addUser(User newUser) {
		userRepository.save(newUser);
	}
	
	public User getUser(int ID) {
		User user = userRepository.findById(ID).get();
		return user;
	}

}
