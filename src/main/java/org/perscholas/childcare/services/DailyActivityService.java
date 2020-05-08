package org.perscholas.childcare.services;


import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.perscholas.childcare.db.DailyActivityRepository;
import org.perscholas.childcare.db.StudentRepository;
import org.perscholas.childcare.dto.DailyActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;



@Configuration
public class DailyActivityService {

	@Autowired
	DailyActivityRepository dailyActivityRepository;

	@Autowired
	StudentRepository studentRepository;
 
	// get all activities
	public List<DailyActivity> listActivities() {
		return dailyActivityRepository.findAll();
	}

	//get activities of a particular student by date
	public DailyActivity get(int studentId, String activityDate) {
		return dailyActivityRepository.findDailyActivitiesByStudentAndActivityDate(studentRepository.findById(studentId).get(), activityDate);
	}


	public void addActivities(DailyActivity dailyActivity) {
		dailyActivityRepository.save(dailyActivity);
	}
	
	//get summary of activities of a particular student of certain period of time(weekly/monthly)
	public List<DailyActivity> getSummary(int studentId, String startDate, String endDate) throws ParseException{
		List<DailyActivity> getAllActivityByStudent = new ArrayList<DailyActivity>();
		getAllActivityByStudent = dailyActivityRepository.findDailyActivitiesByStudent(studentRepository.findById(studentId).get());
		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = LocalDate.parse(endDate);
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
		List<DailyActivity> activitySummary = new ArrayList<DailyActivity>();
		for(DailyActivity da:getAllActivityByStudent) {
			LocalDate activityDate = LocalDate.parse(da.getActivityDate());
			if(activityDate.compareTo(end)<= 0 && activityDate.compareTo(start)>= 0) {
				activitySummary.add(da);
			}
		}
		return activitySummary;
	}
	
}