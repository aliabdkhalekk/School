package qeema.net.service;

import qeema.net.dto.TeacherDTO;

import java.util.List;

public interface TeacherService {

    List<TeacherDTO> findAll();

    TeacherDTO findById(int theId);

    TeacherDTO save(TeacherDTO theTeacher);

    void deleteById(int theId);

}
