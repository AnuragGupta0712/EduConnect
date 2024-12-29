package com.example.website.domain;

import org.springframework.stereotype.Component;

@Component
public interface User {
    public StudentUser createUser(String name,String Gender,String location,String College);
    public Integer saveUser(StudentUser s);

}
