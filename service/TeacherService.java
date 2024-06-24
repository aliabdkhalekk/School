package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Teachers;

import java.util.List;

public interface TeacherService {

    List<Teachers> findAll();

    Teachers findById(int theId);

    Teachers save(Teachers theTeacher);

    void deleteById(int theId);

}
