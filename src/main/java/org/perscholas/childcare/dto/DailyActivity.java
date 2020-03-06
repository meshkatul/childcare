package org.perscholas.childcare.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dailyactivity")
public class DailyActivity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private int activityId;
	private String activityDate;
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	private String meal;
	private String nap;
	private String learning;
	
	
	
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public String getActivityDate() {
		return activityDate;
	}
	public void setActivityDate(String activityDate) {
		this.activityDate = activityDate;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
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
