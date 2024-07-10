package qeema.net.service;

import qeema.net.dao.TeacherRepository;
import qeema.net.dto.TeacherDTO;
import qeema.net.dto.TeacherMapper;
import qeema.net.entity.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qeema.net.exceptions.TeacherNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
public class TeachersServiceImpl implements TeacherService {

    private   final TeacherRepository teacherRepository;
    private   final TeacherMapper teacherMapper;


    @Override
    public List<TeacherDTO> findAll() {
        return teacherRepository.findAll()
                .stream()
                .map(teacherMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDTO findById(int theId) {
        Optional<Teacher> result = teacherRepository.findById(theId);
        return result.map(teacherMapper::toDTO)
                .orElseThrow(() -> new TeacherNotFoundException("Did not find teacher id : " + theId));
    }

    @Override
    public TeacherDTO save(TeacherDTO theTeacherDTO) {
        Teacher teacher = teacherMapper.toEntity(theTeacherDTO);
        Teacher savedTeacher = teacherRepository.save(teacher);
        return teacherMapper.toDTO(savedTeacher);
    }

    @Override
    public void deleteById(int theId) {
       // teacherRepository.findById(theId).orElseThrow(() -> new TeacherNotFoundException("Did not find teacher id : " + theId));
        teacherRepository.deleteById(theId);
    }
}





