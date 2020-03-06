package org.perscholas.childcare.services;

import java.util.ArrayList;
import java.util.List;

import org.perscholas.childcare.db.DailyActivityRepository;
import org.perscholas.childcare.db.StudentRepository;
import org.perscholas.childcare.dto.DailyActivity;
import org.perscholas.childcare.dto.Student;
import org.perscholas.entity.DailyActivityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DailyActivityService {
	
	
	@Autowired
	DailyActivityRepository dailyActivityRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	//get all activities
		public List<DailyActivity> listActivities() {
			return dailyActivityRepository.findAll();
		}
	
	//getting all activities by student id
	public List<DailyActivity> listActivityByStudent(int studentId, String date) {
		List<DailyActivity> allActivities = dailyActivityRepository.findAll();
		List<DailyActivity> activitiesOfAStudent = new ArrayList<DailyActivity>();

		for (DailyActivity da : allActivities) {
			if ((da.getStudent().getStudentId() == studentId) && (da.getActivityDate().equals(date)))  {
				activitiesOfAStudent.add(da);
			}
		} return activitiesOfAStudent;
	}
	
	//adding activities  
	public void addActivities(DailyActivity dailyActivity) {
		dailyActivityRepository.save(dailyActivity);
	}
	
	//adding activities by student id
	public DailyActivity addDailyActivity(DailyActivityEntity dailyActivityEntity) {
		DailyActivity dailyActivity = new DailyActivity();
		dailyActivity.setActivityDate(dailyActivityEntity.getActivityDate());
		dailyActivity.setMeal(dailyActivityEntity.getMeal());
		dailyActivity.setNap(dailyActivityEntity.getNap());
		dailyActivity.setLearning(dailyActivityEntity.getLearning());
		
		Student student = studentRepository.findById(dailyActivityEntity.getStudentId()).get();
		
		dailyActivity.setStudent(student);
		
		return dailyActivityRepository.save(dailyActivity);
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
