package org.perscholas.childcare.controllers;

import org.perscholas.childcare.dto.DailyActivity;
import org.perscholas.childcare.dto.Student;
import org.perscholas.childcare.services.DailyActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("activities")
public class DailyActivityController {
	@Autowired
	DailyActivityService dailyActivityService;
	
	
	// show calendar page
		@RequestMapping(value = "/calendar", method = RequestMethod.GET)
		public String viewRegistrationPage(Model model) {
			return "calendar";
		}

		
	// show activity page
	@RequestMapping(value = "/{studentId}/{activityDate}", method = RequestMethod.GET)
	public String viewActivityPage(@PathVariable("studentId") int studentId, @PathVariable("activityDate") String date,
			Model model) {
		DailyActivity dailyActivity = dailyActivityService.get(studentId, date);

		if (dailyActivity == null) {
			System.out.println("Could not find DailyActivity: " + studentId + " - " + date);
			dailyActivity = new DailyActivity();

			Student student = new Student();
			student.setStudentId(studentId);
			dailyActivity.setStudent(student);
			dailyActivity.setActivityDate(date);
		} else {
			System.out.println("Retrieved DailyActivity: " + studentId + " - " + date);
		}

		model.addAttribute("dailyActivity", dailyActivity);
		return "activity";
	}

	@RequestMapping(value = "/{studentId}/{activityDate}", method = RequestMethod.POST)
	public String saveActivity(@PathVariable("studentId") int studentId, @PathVariable("activityDate") String date,
			@ModelAttribute("dailyActivity") DailyActivity dailyActivity) {
		System.out.println("IN dailyActivity/POST");
		dailyActivityService.addActivities(dailyActivity);
		return "activity";
	}

}
