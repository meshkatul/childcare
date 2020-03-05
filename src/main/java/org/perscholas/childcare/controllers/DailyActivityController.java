package org.perscholas.childcare.controllers;


import java.util.List;

import org.perscholas.childcare.dto.DailyActivity;
import org.perscholas.childcare.services.DailyActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("activity")
public class DailyActivityController {
	@Autowired
	DailyActivityService dailyActivityService;
	
	@GetMapping
	public List<DailyActivity> list() {
		return dailyActivityService.listActivities();
	}
	
	
	@GetMapping("student/{id}/{date}")
	public List<DailyActivity> getActivityByStudent(@PathVariable String id, @PathVariable String date) {
		return dailyActivityService.listActivityByStudent(Integer.parseInt(id), date);
	}
	
//	@GetMapping("{date}/activities") 
//	public List<DailyActivity> getActivityByDate(@PathVariable String date) {
//		return dailyActivityService.listActivityByDate(date);
//	}

}
