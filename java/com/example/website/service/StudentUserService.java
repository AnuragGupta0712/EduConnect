package com.example.website.service;

import com.example.website.domain.StudentUser;
import com.example.website.domain.User;
import com.example.website.repository.StudentUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StudentUserService implements UserService{

    @Qualifier("studentUser")
    @Autowired
    User StudentUser;
    StudentUserDAO studentUserDAO;

    // Return an empty User object for us so that we can take it to fill up our form
    @Override
    public User getUser() {
        return StudentUser;
    }

    @Override
    public int signUp(String name, String Gender, String location, String College) {
        StudentUser student =  StudentUser.createUser(name, Gender, location, College);
        if(student != null){
            return StudentUser.saveUser(student);
        }
        else {
            return -1;
        }

    }



}
