package org.perscholas.childcare.db;


import org.perscholas.childcare.dto.DailyActivity;
import org.perscholas.childcare.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyActivityRepository extends JpaRepository<DailyActivity, Integer> {
	
	DailyActivity findDailyActivitiesByStudentAndActivityDate(Student student, String activityDate);
}
