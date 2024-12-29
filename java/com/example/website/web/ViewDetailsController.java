package com.example.website.web;

import com.example.website.domain.StudentUser;
import com.example.website.repository.StudentUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewDetailsController {
    @Autowired
    StudentUserDAO studentUserDAO;
    @RequestMapping("/showDetails")
    public String showDetails(@RequestParam("studentId") Integer studentID, ModelMap map) {
        StudentUser studentUser = studentUserDAO.get(studentID).orElse(null);
        if(studentUser != null) {
            map.addAttribute("userName", studentUser.getName());
            map.addAttribute("userGender", studentUser.getGender());
            map.addAttribute("userCollege", studentUser.getCollege());
            return "showDetails";
        }
        else {
            return "home";
        }

    }
}
