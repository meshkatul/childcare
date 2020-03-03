package org.perscholas.childcare.dto;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class ClassRoom {
	@Id
	private int classId;
	private String className;
	
	public ClassRoom() {
		
	}

	public ClassRoom(int classId, String className) {
		super();
		this.classId = classId;
		this.className = className;
	}

	public int getClassRoomID() {
		return classId;
	}

	public void setClassRoomID(int classRoomID) {
		this.classId = classRoomID;
	}

	public String getClassRoomName() {
		return className;
	}

	public void setClassRoomName(String classRoomName) {
		this.className = classRoomName;
	}
	
	

}
