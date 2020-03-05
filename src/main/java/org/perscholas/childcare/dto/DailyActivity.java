package org.perscholas.childcare.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "dailyactivity")
public class DailyActivity {
	
	@Id
	private int activityId;
	private String activityDate;
	private String activityName;
	private String activityDescription;
	private int studentId;
	
	public DailyActivity() {
		
	}

	public DailyActivity(int activityId, String activityDate, String activityName, String activityDescription,
			int studentId) {
		this.activityId = activityId;
		this.activityDate = activityDate;
		this.activityName = activityName;
		this.activityDescription = activityDescription;
		this.studentId = studentId;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getActivityDate() {
		return activityDate;
	}

	public void setActivityByDate(String activityByDate) {
		this.activityDate = activityByDate;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityDescription() {
		return activityDescription;
	}

	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	
}
