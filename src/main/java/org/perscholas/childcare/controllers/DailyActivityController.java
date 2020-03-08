package org.perscholas.childcare.controllers;

import org.perscholas.childcare.services.DailyActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("activities2")
public class DailyActivityController {
    @Autowired
    DailyActivityService dailyActivityService;


    // show calendar page
    @RequestMapping(value = "/calendar", method = RequestMethod.GET)
    public String viewRegistrationPage(Model model) {
        return "calendar";
    }


    // show activity page


}
