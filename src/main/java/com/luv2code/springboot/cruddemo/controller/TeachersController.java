package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.dto.TeacherDTO;
import com.luv2code.springboot.cruddemo.entity.Teacher;
import com.luv2code.springboot.cruddemo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/teacherses")
public class TeachersController {
    private static final Logger logger = LogManager.getLogger(TeachersController.class);

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> getAllTeachers() {
        logger.info("Fetching all teachers");
        List<TeacherDTO> teachers = teacherService.findAll();
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable int id) {
        logger.info("Fetching teacher with id: {}", id);
        TeacherDTO teacher = teacherService.findById(id);
        return ResponseEntity.ok(teacher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacherById(@PathVariable int id) {
        logger.info("Deleting teacher with id: {}", id);
        teacherService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<TeacherDTO> createTeachers(@RequestBody TeacherDTO teacher) {
        logger.info("Creating new teacher: {}", teacher);
        TeacherDTO savedTeacher = teacherService.save(teacher);
        return ResponseEntity.ok(savedTeacher);    }

    @PutMapping
    public ResponseEntity<TeacherDTO> updateTeacher(@RequestBody TeacherDTO teacher) {
        logger.info("Updating teacher with id: {}", teacher.id());
        TeacherDTO updatedTeacher = teacherService.save(teacher);
        return ResponseEntity.ok(updatedTeacher);
    }
}