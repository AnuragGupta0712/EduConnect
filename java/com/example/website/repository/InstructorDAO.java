package com.example.website.repository;

import com.example.website.domain.StudentUser;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
@Repository
public class InstructorDAO {
    private final ArrayList<HashMap<String,Object>> instructorsList = new ArrayList<>();
    public Optional<HashMap<String,Object>> get(String id) {
        for(int i = 0; i < instructorsList.size(); i++){
           // if(instructorsList.get(i).get("id").equals(id)){
            if(String.valueOf(instructorsList.get(i).get("id")).equals(id)) {
                return Optional.of(instructorsList.get(i));
            }
        }
        return Optional.empty();
    }
    public void saveInstructor(HashMap<String,Object> instructor) {
        instructorsList.add(instructor);
    }
}
