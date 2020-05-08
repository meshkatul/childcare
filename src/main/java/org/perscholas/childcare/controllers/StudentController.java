package org.perscholas.childcare.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.perscholas.childcare.db.ParentRepository;
import org.perscholas.childcare.dto.DailyActivity;
import org.perscholas.childcare.dto.Parent;
import org.perscholas.childcare.dto.Student;
import org.perscholas.childcare.services.DailyActivityService;
import org.perscholas.childcare.services.ParentService;
import org.perscholas.childcare.services.SecurityService;
import org.perscholas.childcare.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("students")
public class StudentController {
	@Autowired
	StudentService studentService;

	@Autowired
	DailyActivityService dailyActivityService;

	@Autowired
	ParentService parentService;

	@Autowired
	SecurityService securityService;

	@Autowired
	ParentRepository parentRepository;

	// show student list page
	@RequestMapping
	public String viewStudentPage(Model model) {
		List<Student> listStudent = studentService.listStudents();
		// System.out.println("StudentListSize: " + listStudent.size());
		model.addAttribute("listStudent", listStudent);
		return "studentList";
	}

	// show individual student page and search for activity by date
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String viewStudentInfoPage(@PathVariable int id, Model model) {
		Student student = studentService.getStudent(id);
		model.addAttribute(student);
		@SuppressWarnings("unchecked")
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder
				.getContext().getAuthentication().getAuthorities();

		Set<String> roles = authorities.stream().map(r -> r.getAuthority()).collect(Collectors.toSet());
		if (roles.contains("ROLE_ADMIN")) {
			return "studentInfo";
		} else if (roles.contains("ROLE_PARENT")) {
			Parent parent = parentRepository.findByEmail(securityService.getCurrentUser());
			Student stu = studentService.getStudentByParent(parent);
			if (stu.getStudentId() == id) {
				return "studentInfo";
			} else {
				return "accessDenied";
			}
		}
		return "index";
	}

	// view students activity by date
	@RequestMapping(value = "/activities/{studentId}/{activityDate}", method = RequestMethod.GET)
	public String viewActivityPage(@PathVariable("studentId") int studentId, @PathVariable("activityDate") String date,
			Model model) {
		DailyActivity dailyActivity = dailyActivityService.get(studentId, date);

		@SuppressWarnings("unchecked")
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder
				.getContext().getAuthentication().getAuthorities();
		Set<String> roles = authorities.stream().map(r -> r.getAuthority()).collect(Collectors.toSet());

		if (roles.contains("ROLE_ADMIN")) {
			if (dailyActivity == null) {
				System.out.println("Could not find DailyActivity: " + studentId + " - " + date);
				dailyActivity = new DailyActivity();
				Student student = studentService.getStudent(studentId);
				dailyActivity.setStudent(student);
				dailyActivity.setActivityDate(date);
			} else {
				System.out.println("Retrieved DailyActivity: " + studentId + " - " + date);
			}
			model.addAttribute("dailyActivity", dailyActivity);
			return "addActivity";
		} else if (roles.contains("ROLE_PARENT")) {
			Parent parent = parentRepository.findByEmail(securityService.getCurrentUser());
			Student stu = studentService.getStudentByParent(parent);
			if ((dailyActivity == null) && (stu.getStudentId() == studentId)) {
				System.out.println("Could not find DailyActivity: " + studentId + " - " + date);
				dailyActivity = new DailyActivity();
				Student student = studentService.getStudent(studentId);
				dailyActivity.setStudent(student);
				dailyActivity.setActivityDate(date);
			} else if ((dailyActivity != null) && (stu.getStudentId() == studentId)) {
				System.out.println("Retrieved DailyActivity: " + studentId + " - " + date);
			} else {
				return "accessDenied";
			}
			model.addAttribute("dailyActivity", dailyActivity);
			return "viewActivity";
		}
		return "index";
	}

	// edit/add students activity
	@RequestMapping(value = "/activities/{studentId}/{activityDate}", method = RequestMethod.POST)
	public String saveActivity(@PathVariable("studentId") int studentId, @PathVariable("activityDate") String date,
			@ModelAttribute("dailyActivity") DailyActivity dailyActivity) {
		System.out.println("IN dailyActivity/POST");
		dailyActivityService.addActivities(dailyActivity);
		return "redirect:/students/" + studentId;
	}

	// activity summary
	@GetMapping(path="/activities/{studentId}/{startDate}/{endDate}", produces = "application/json")
	public @ResponseBody List<DailyActivity> getActivitySummary(@PathVariable("studentId") int studentId,
			@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate)
			throws ParseException {
		System.out.println("IN activitySummary/POST");
		List<DailyActivity> activitySummary = new ArrayList<DailyActivity>();
		activitySummary = dailyActivityService.getSummary(studentId, startDate, endDate);
		return activitySummary;
	}
}
