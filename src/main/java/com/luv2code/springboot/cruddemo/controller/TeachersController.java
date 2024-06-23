package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.dao.TeacherRepository;
import com.luv2code.springboot.cruddemo.entity.Address;
import com.luv2code.springboot.cruddemo.entity.Teachers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/teacherses")
public class TeachersController {
    private static final Logger logger = LogManager.getLogger(TeachersController.class);

    @Autowired
    private TeacherRepository teachersRepository;

//
//    @GetMapping
//    public List<Teachers> getAllTeachers() {
//        return teachersRepository.findAll();
//    }
@GetMapping("/{id}")
public ResponseEntity<Teachers> getTeacherById(@PathVariable int id) {
    Teachers teacher = teachersRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + id));
    return ResponseEntity.ok(teacher);
}
    @DeleteMapping("/{id}")
    public void deleteTeacherById(@PathVariable int id) {
        teachersRepository.deleteById(id);
    }
//    @PostMapping
//    public Teachers createTeachers(@RequestBody Teachers teachers) {
//        return teachersRepository.save(teachers);
//    }
    @PutMapping("/{id}")
    public Teachers updateTeacher(@PathVariable int id, @RequestBody Teachers teacherDetails) {
        // Fetch the existing teacher
        Teachers existingTeacher = teachersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + id));

        // Update the teacher's details
        existingTeacher.setFirstName(teacherDetails.getFirstName());
        existingTeacher.setLastName(teacherDetails.getLastName());
        existingTeacher.setAge(teacherDetails.getAge());

        // Handle addresses
        Set<Address> updatedAddresses = teacherDetails.getAddresses();
        if (updatedAddresses != null) {
            for (Address address : updatedAddresses) {
                if (address.getId() != 0) {
                    // Existing address, find and update
                    for (Address existingAddress : existingTeacher.getAddresses()) {
                        if (existingAddress.getId() == address.getId()) {
                            existingAddress.setStreetName(address.getStreetName());
                            existingAddress.setCountry(address.getCountry());
                            existingAddress.setGovernment(address.getGovernment());
                        }
                    }
                } else {
                    existingTeacher.addAddress(address);
                }
            }
        }

        // Save the updated teacher
        return teachersRepository.save(existingTeacher);
    }
}
