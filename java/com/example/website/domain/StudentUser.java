package com.example.website.domain;

import com.example.website.repository.StudentUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.rmi.StubNotFoundException;

@Component
public class StudentUser implements User{

    @Autowired
    StudentUserDAO studentUserDAO;
    String name;
    String Gender;
    String location;
    String College;
    int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getCollege() {
        return College;
    }

    public void setCollege(String college) {
        College = college;
    }

    @Override
    public StudentUser createUser(String name, String Gender, String location, String College) {
        StudentUser s = new StudentUser();
        s.name=name;
        s.Gender=Gender;
        s.location=location;
        s.College=College;
        return s;
    }

    @Override
    public Integer saveUser(StudentUser s) {
        System.out.println(s.name);
        return studentUserDAO.save(s);
    }
}
