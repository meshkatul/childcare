package org.perscholas.childcare.dto;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class ClassRoom {
	@Id
	private int classId;
	private String className;
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	


}
