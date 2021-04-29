package com.upgrad.dcf.service;

import com.upgrad.dcf.model.user;
import com.upgrad.dcf.repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {

    @Autowired
    private userRepo userRepo;

    public List<user> getAllUserInfo(){ return userRepo.getAllPosts(); }

    public boolean addUser(user newuser){ return userRepo.addNewUser(newuser); }

    public void deleteUser(Integer userId) {userRepo.deleteUser(userId);};
    public void updateUser(user updateuser) {userRepo.updateUser(updateuser);}
    public user getUser(String userName) {return userRepo.getUser(userName);}
    public boolean check(String userName){return userRepo.check(userName);}
}
