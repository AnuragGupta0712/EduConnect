package com.example.website.repository;

import com.example.website.domain.StudentUser;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Scope("singleton")
public class StudentUserDAO implements DAO<StudentUser> {
    private  List<StudentUser> studentUserList = new ArrayList<StudentUser>();

    @Override
    public Optional<StudentUser> get(Integer id) {
        if(!studentUserList.isEmpty() && id < studentUserList.size()) {
          return Optional.of(studentUserList.get(id));
        }
        
        return Optional.empty();
    }

    @Override
    public int save(StudentUser student) {
        int id = studentUserList.size();
        student.setId(id);
        studentUserList.add(student);
        System.out.println("Student number "+ id + " added");
        System.out.println("The size of the list is " + studentUserList.size());
        return id;
    }
}


