package com.upgrad.dcf.service;

import com.upgrad.dcf.model.User;
import com.upgrad.dcf.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private static UserRepo userRepo;

    public List<User> getAllUserInfo(){
        return userRepo.getAllPosts();
    }

    public static boolean addUser(User newuser){
        return userRepo.addNewUser(newuser);
    }
    //public void editUser(Integer userId) {userRepo.editUser(userId);};
    public void deleteUser(Integer userId) {userRepo.deleteUser(userId);};
    public void updateUser(User updateuser) {userRepo.updateUser(updateuser);}
    public User getUser(String userName) {return userRepo.getUser(userName);}
    public boolean check(String userName){return userRepo.check(userName);}
}
