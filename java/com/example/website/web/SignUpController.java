package com.example.website.web;

import com.example.website.domain.StudentUser;
import com.example.website.domain.User;
import com.example.website.repository.InstructorDAO;
import com.example.website.repository.StudentUserDAO;
import com.example.website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@Controller
public class SignUpController {
@Autowired
UserService userService;
@Autowired
StudentUserDAO studentUserDAO;
@Autowired
InstructorDAO instructorDAO;

	@RequestMapping("/signUp")
	public String getSignUpPage(Model uiModel) {
		User user = userService.getUser();
		// In the line given below the first "User" is the key given to the object user,which is written after comma
		// One more thing,whatever we are writing in the attributeName here(like User or Userxyz or whatever ), same cheez has to be written in modelAttribute ="---"
		uiModel.addAttribute("User",user);
		return "signup";
	}
	@RequestMapping("/registerUser")
	//Here the @ModelAttribute(value = "User") is written ,its ideal practice that it should match with the attributeName of uiModel.addAttribute("User")
	public String createdUser(@ModelAttribute(value = "User")StudentUser studentUser) {
	int userId = userService.signUp(studentUser.getName(),studentUser.getGender(),studentUser.getLocation(),studentUser.getCollege());
		if(userId != -1) {
			ModelAndView modelAndView = new ModelAndView("redirect:/welcome?id="+userId);
			return modelAndView.getViewName();
		}
			return "signup";
	}

	@RequestMapping("/welcome")
	public String showWelcomePage(@RequestParam("id") String userID, ModelMap map) {
			map.addAttribute("userID",userID);
			return "welcome";
	}
	@RequestMapping("/viewDetails")
	public String viewDetails(){
		return "viewDetails";
	}
	@RequestMapping("/instructors")
	public String showInstructors(ModelMap map) {
		// Creating the Instructors
		HashMap<String,Object> instructor1 = new HashMap<>();
		instructor1.put("name","Instructor 1");
		instructor1.put("age",35);
		instructor1.put("id",243);
		//saving the instructor in the instructor DAO
		instructorDAO.saveInstructor(instructor1);

		HashMap<String,Object> instructor2 = new HashMap<>();
		instructor2.put("name","Instructor 2");
		instructor2.put("age",48);
		instructor2.put("id",181);
		instructorDAO.saveInstructor(instructor2);

		// Creating the List of Instructor for the instructor page
		ArrayList<HashMap<String,Object>> listOfInstructors = new ArrayList<HashMap<String,Object>>();
		listOfInstructors.add(instructor1);
		listOfInstructors.add(instructor2);
		//Sending key value pair to the jsp
		map.addAttribute("instructors",listOfInstructors);
		return "instructors";
	}
	@RequestMapping("/profile/{profileID}")
	public String showProfile(@PathVariable("profileID") String profileID, ModelMap map) {
		Optional<HashMap<String, Object>> profile = instructorDAO.get(profileID);
		if (profile.isPresent()) {
			//This is to check whether it is hitting the request or not
			System.out.println("The name of the instructor is " +profile.get().get("name"));

			map.addAttribute("instructorName", profile.get().get("name"));
			map.addAttribute("instructorAge", profile.get().get("age"));
			map.addAttribute("instructorID", profile.get().get("id"));
		} else {
			map.addAttribute("error", "Instructor not found");
		}
		return "profile";
	}
}
