package com.upgrad.dcf.controller;

import com.upgrad.dcf.model.User;
import com.upgrad.dcf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/userinfoform")
    public String userRegistration(User user, RedirectAttributes redirAttrs) {
        // Business logic to save the credentials. of the users to teh given database
        boolean status = UserService.addUser(user);
        if(!status){
            redirAttrs.addFlashAttribute("error","User Already Exists");
            return "redirect:/";
        }
        else {
            redirAttrs.addFlashAttribute("success","User Info Submitted");
            return "redirect:/";
        }

    }
}