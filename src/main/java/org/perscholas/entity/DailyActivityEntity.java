package org.perscholas.entity;

public class DailyActivityEntity {
	private String activityDate;
	private int studentId;
	private String meal;
	private String nap;
	private String learning;
	

	public String getActivityDate() {
		return activityDate;
	}
	public void setActivityDate(String activityDate) {
		this.activityDate = activityDate;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public String getNap() {
		return nap;
	}
	public void setNap(String nap) {
		this.nap = nap;
	}
	
	public String getLearning() {
		return learning;
	}
	public void setLearning(String learning) {
		this.learning = learning;
	}
	

}
