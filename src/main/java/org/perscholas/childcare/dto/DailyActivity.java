package org.perscholas.childcare.dto;

import java.util.Date;

public class DailyActivity {
	private int activityId;
	private Date activityByDate;
	private String activityName;
	private String activityDescription;
	private int studentId;
	
	public DailyActivity() {
		
	}

	public DailyActivity(int activityId, Date activityByDate, String activityName, String activityDescription,
			int studentId) {
		super();
		this.activityId = activityId;
		this.activityByDate = activityByDate;
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

	public Date getActivityByDate() {
		return activityByDate;
	}

	public void setActivityByDate(Date activityByDate) {
		this.activityByDate = activityByDate;
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
