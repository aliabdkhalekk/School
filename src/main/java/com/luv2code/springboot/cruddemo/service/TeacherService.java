package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dto.TeacherDTO;
import com.luv2code.springboot.cruddemo.entity.Teacher;

import java.util.List;

public interface TeacherService {

    List<TeacherDTO> findAll();

    TeacherDTO findById(int theId);

    TeacherDTO save(TeacherDTO theTeacher);

    void deleteById(int theId);

}
