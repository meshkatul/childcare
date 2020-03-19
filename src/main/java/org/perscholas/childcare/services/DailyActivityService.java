package org.perscholas.childcare.services;

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

	public DailyActivity get(int studentId, String activityDate) {
		return dailyActivityRepository
				.findDailyActivitiesByStudentAndActivityDate(studentRepository.findById(studentId).get(), activityDate);
	}


	public void addActivities(DailyActivity dailyActivity) {
		dailyActivityRepository.save(dailyActivity);
	}

}