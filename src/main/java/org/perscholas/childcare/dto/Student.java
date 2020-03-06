package org.perscholas.childcare.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	@Id
	private int studentId;
	private String stuFirstName;
	private String stuLastName;
	@ManyToOne
	@JoinColumn(name="class_id")
	private ClassRoom classRoom;
	
	
	public ClassRoom getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStuFirstName() {
		return stuFirstName;
	}

	public void setStuFirstName(String stuFirstName) {
		this.stuFirstName = stuFirstName;
	}

	public String getStuLastName() {
		return stuLastName;
	}

	public void setStuLastName(String stuLastName) {
		this.stuLastName = stuLastName;
	}

	

}
