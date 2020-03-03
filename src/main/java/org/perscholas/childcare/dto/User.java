package org.perscholas.childcare.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String role;
	
	
	public User() {
		
	}

	public User(int userId, String firstName, String lastName, String email, String password, String role) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserID(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public void eat() {
		System.out.println("eating");
		
	}

}
