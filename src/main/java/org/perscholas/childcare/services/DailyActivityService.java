package org.perscholas.childcare.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.perscholas.childcare.db.DailyActivityRepository;
import org.perscholas.childcare.dto.DailyActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DailyActivityService {
	
	
	@Autowired
	DailyActivityRepository dailyActivityRepository;
	
	//get all activities
		public List<DailyActivity> listActivities() {
			return dailyActivityRepository.findAll();
		}
	
	//getting all activities by student id
	public List<DailyActivity> listActivityByStudent(int studentId, String date) {
		List<DailyActivity> allActivities = dailyActivityRepository.findAll();
		List<DailyActivity> activitiesOfAStudent = new ArrayList<DailyActivity>();

		for (DailyActivity da : allActivities) {
			if ((da.getStudentId() == studentId) && (da.getActivityDate().equals(date)))  {
				activitiesOfAStudent.add(da);
			}
		} return activitiesOfAStudent;
	}

	
//	public List<DailyActivity> listActivityByDate(String activityDate) {
//		List<DailyActivity> allActivities = dailyActivityRepository.findAll();
//		List<DailyActivity> activitiesOfAStudent = new ArrayList<DailyActivity>();
//
//		for (DailyActivity da : allActivities) {
//			if (da.getActivityDate().equals(activityDate)) {
//				activitiesOfAStudent.add(da);
//			}
//		} return activitiesOfAStudent;
//	}
}
