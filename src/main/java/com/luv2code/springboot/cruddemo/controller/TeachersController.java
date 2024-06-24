package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.entity.Teachers;
import com.luv2code.springboot.cruddemo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@RestController
@RequestMapping("/teacherses")
public class TeachersController {
    private static final Logger logger = LogManager.getLogger(TeachersController.class);

    @Autowired
    private TeacherService teacherService;


    @GetMapping
    public List<Teachers> getAllTeachers() {
        return teacherService.findAll();
    }

    @GetMapping("/{id}")
    public Teachers getTeacherById(@PathVariable int id) {
        Teachers teacher = teacherService.findById(id);
        if (teacher == null) {
            throw new RuntimeException("Teacher not found" + id);
        }
        return teacher;
    }

    @DeleteMapping("/{id}")
    public String deleteTeacherById(@PathVariable int id) {
        Teachers teacher = teacherService.findById(id);
        if (teacher == null) {
            throw new RuntimeException("Teacher not found" + id);
        }
        teacherService.deleteById(id);
        return "Teacher deleted ID : " + id;
    }

    @PostMapping
    public Teachers createTeachers(@RequestBody Teachers teachers) {
        return teacherService.save(teachers);
    }


    @PutMapping
    public Teachers updateTeacher(@RequestBody Teachers teacher) {
        Teachers teachers = teacherService.save(teacher);

        return teachers;
    }
}
