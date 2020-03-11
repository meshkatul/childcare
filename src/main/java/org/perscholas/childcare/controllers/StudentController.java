package org.perscholas.childcare.controllers;


import java.util.List;

import org.perscholas.childcare.dto.DailyActivity;
import org.perscholas.childcare.dto.Student;
import org.perscholas.childcare.services.DailyActivityService;
import org.perscholas.childcare.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    DailyActivityService dailyActivityService;


 // show student list page
 	@RequestMapping
 	public String viewStudentPage(Model model) {
 		List<Student> listStudent = studentService.listStudents();
 		//System.out.println("StudentListSize: " + listStudent.size());
 		model.addAttribute("listStudent", listStudent);
 		return "student";
 	}


	//show individual student page
	@RequestMapping(value ="{id}", method = RequestMethod.GET )
	public String viewStudentInfoPage(@PathVariable int id, Model model) {
		Student student = studentService.getStudent(id);
		model.addAttribute(student);
		return "studentInfo";
	}

    // add new student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.save(student);

    }
    @RequestMapping(value = "/activities/{studentId}/{activityDate}", method = RequestMethod.GET)
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

    @RequestMapping(value = "/activities/{studentId}/{activityDate}", method = RequestMethod.POST)
    public String saveActivity(@PathVariable("studentId") int studentId, @PathVariable("activityDate") String date,
                               @ModelAttribute("dailyActivity") DailyActivity dailyActivity) {
        System.out.println("IN dailyActivity/POST");
        dailyActivityService.addActivities(dailyActivity);
        return "activity";
    }
}
