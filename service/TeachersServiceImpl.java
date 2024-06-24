package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.TeacherRepository;
import com.luv2code.springboot.cruddemo.entity.Teachers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeachersServiceImpl implements TeacherService {

    private TeacherRepository employeeRepository;

    @Autowired
    public TeachersServiceImpl(TeacherRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Teachers> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Teachers findById(int theId) {
        Optional<Teachers> result = employeeRepository.findById(theId);

        Teachers theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    @Override
    public Teachers save(Teachers theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}






