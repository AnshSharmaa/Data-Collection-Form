package com.upgrad.dcf.controller;

import com.upgrad.dcf.model.user;
import com.upgrad.dcf.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class userInfoController {

    @Autowired
    private userService userService;

    @RequestMapping("/userinfo")
    public String display(Model model){
        List<user> users = userService.getAllUserInfo();
        model.addAttribute("user", new user());
        model.addAttribute("users",users);
        return "userinfo";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public String search(@RequestParam("name") String userName,Model model ,RedirectAttributes redirAttrs){
        user user = new user();
        if(userService.check(userName)){
            user = userService.getUser(userName);
            model.addAttribute("user",user);
            return "search";
        } else {
            redirAttrs.addFlashAttribute("notfound","User Not Found");
            return "redirect:/userinfo";
        }
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/edituser")
    public String editUser(@RequestParam(name = "userId") Integer userId, user updateuser, RedirectAttributes redirAttrs){
        updateuser.setId(userId);
        userService.updateUser(updateuser);
        redirAttrs.addFlashAttribute("success","User Edited Successfully");
        return "redirect:/userinfo";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteuser")
    public String deletePost(@RequestParam(name = "userId") Integer userId) {
        userService.deleteUser(userId);
        return "redirect:/userinfo";
    }

}