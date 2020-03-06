package org.perscholas.childcare.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dailyactivity")
public class DailyActivity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private int activityId;
	private String activityDate;
	private int studentId;
	private String meal;
	private String nap;
	private String restroomUse;
	private String learning;
	private String incident;
	private String supply;
	

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


	public String getRestroomUse() {
		return restroomUse;
	}


	public void setRestroomUse(String restroomUse) {
		this.restroomUse = restroomUse;
	}


	public String getLearning() {
		return learning;
	}


	public void setLearning(String learning) {
		this.learning = learning;
	}


	public String getIncident() {
		return incident;
	}


	public void setIncident(String incident) {
		this.incident = incident;
	}


	public String getSupply() {
		return supply;
	}


	public void setSupply(String supply) {
		this.supply = supply;
	}
	
	
}
