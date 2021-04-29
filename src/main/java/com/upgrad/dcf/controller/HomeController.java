package com.upgrad.dcf.controller;

import com.upgrad.dcf.model.user;
import com.upgrad.dcf.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @Autowired
    private userService userService;

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("user", new user());
        return "home";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/adduser")
    public String userRegistration(user user, RedirectAttributes redirAttrs) {
        // Business logic to save the credentials. of the users to teh given database
        boolean status = userService.addUser(user);
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