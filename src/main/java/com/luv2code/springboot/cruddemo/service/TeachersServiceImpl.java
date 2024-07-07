package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.TeacherRepository;
import com.luv2code.springboot.cruddemo.dto.TeacherDTO;
import com.luv2code.springboot.cruddemo.dto.TeacherDTOConverter;
import com.luv2code.springboot.cruddemo.dto.TeacherDTOMapper;
import com.luv2code.springboot.cruddemo.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeachersServiceImpl implements TeacherService {

    private  TeacherRepository teacherRepository;
    private   final  TeacherDTOMapper teacherDTOMapper;

    @Autowired
    public TeachersServiceImpl(TeacherRepository teacherRepository, TeacherDTOMapper teacherDTOMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherDTOMapper = teacherDTOMapper;
    }

    @Override
    public List<TeacherDTO> findAll() {
        return teacherRepository.findAll()
                .stream()
                .map(teacherDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDTO findById(int theId) {
        Optional<Teacher> result = teacherRepository.findById(theId);

        return result.map(teacherDTOMapper)
                .orElseThrow(() -> new RuntimeException("Did not find teacher id - " + theId));
    }

    @Override
    public TeacherDTO save(TeacherDTO theTeacherDTO) {
        Teacher teacherEntity = TeacherDTOConverter.toTeacherEntity(theTeacherDTO);
        Teacher savedTeacher = teacherRepository.save(teacherEntity);
        return teacherDTOMapper.apply(savedTeacher);
    }

    @Override
    public void deleteById(int theId) {
        teacherRepository.deleteById(theId);
    }
}





