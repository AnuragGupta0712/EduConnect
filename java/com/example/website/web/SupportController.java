package com.example.website.web;

import com.example.website.repository.StudentUserDAO;
import com.example.website.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SupportController {
    @Autowired
    UserMessageService userMessageService;

    @Autowired
    StudentUserDAO studentUserDAO;

//    @RequestMapping("/support")
//    public String getSupportPage(@RequestParam("id") String id, ModelMap map) {
////        String finalUserMessage = userMessageService.createMessage(Integer.parseInt(id));
////        uiModel.addAttribute("userMessage", finalUserMessage);
//        map.addAttribute("message","Welcome to the Support Page " + id );
//        return "support";
//    }

    @RequestMapping("/support")
    public String getSupportPage(@RequestParam("id") String id, ModelMap map) {
//        String finalUserMessage = userMessageService.createMessage(Integer.parseInt(id));
//        uiModel.addAttribute("userMessage", finalUserMessage);
        if(studentUserDAO.get(Integer.parseInt(id))!=null) {
            map.addAttribute("message", "Hii from" + studentUserDAO.get(Integer.parseInt(id)).get().getName());
            return "support";
        }
        return "welcome";
    }
}
