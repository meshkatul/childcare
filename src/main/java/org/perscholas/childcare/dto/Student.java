package org.perscholas.childcare.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private int studentId;
	private String stuFirstName;
	private String stuLastName;
	private int classId;
	
	
	public Student() {
		
	}

	public Student(int studentId, String stuFirstName, String stuLastName, int classId) {
		this.studentId = studentId;
		this.stuFirstName = stuFirstName;
		this.stuLastName = stuLastName;
		this.classId = classId;
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

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}
	

}
