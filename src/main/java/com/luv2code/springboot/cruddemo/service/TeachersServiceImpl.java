package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.TeacherRepository;
import com.luv2code.springboot.cruddemo.entity.Teachers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeachersServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;

    @Autowired
    public TeachersServiceImpl(TeacherRepository theTeacherRepository) {
        teacherRepository = theTeacherRepository;
    }

    @Override
    public List<Teachers> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teachers findById(int theId) {
        Optional<Teachers> result = teacherRepository.findById(theId);

        Teachers theTeacher = null;

        if (result.isPresent()) {
            theTeacher = result.get();
        }
        else {
            throw new RuntimeException("Did not find teacher id - " + theId);
        }

        return theTeacher;
    }

    @Override
    public Teachers save(Teachers theTeacher) {
        return teacherRepository.save(theTeacher);
    }

    @Override
    public void deleteById(int theId) {
        teacherRepository.deleteById(theId);
    }
}






