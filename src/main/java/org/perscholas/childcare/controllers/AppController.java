package org.perscholas.childcare.controllers;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.perscholas.childcare.dto.Student;
import org.perscholas.childcare.services.DailyActivityService;
import org.perscholas.childcare.services.ParentService;
import org.perscholas.childcare.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @Autowired
    StudentService studentService;

    @Autowired
    ParentService parentService;

    @Autowired
    DailyActivityService dailyActivityService;


	//show home page
    @RequestMapping({"/", "/home"})
    public String homePage() {
        return "home";
    }
    
    //show login page
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    

    //authentication and give access based on roles
    @RequestMapping({"/index"})
    public String index() {
        @SuppressWarnings("unchecked")
		Collection<SimpleGrantedAuthority> authorities =
                (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        Set<String> roles = authorities.stream()
                .map(r -> r.getAuthority()).collect(Collectors.toSet());
        if (roles.contains("ROLE_ADMIN")) {
            return "redirect:/students";
        } else if (roles.contains("ROLE_PARENT")) {
            Student student = parentService.getStudentByParent();

            return "redirect:/students/" + student.getStudentId();
        }

        return "index";
    }
    
  

    
    
    
    @RequestMapping("/infants")
    public String infant() {
        return "infants";
    }


}
