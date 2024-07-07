package com.luv2code.springboot.cruddemo.dto;

import com.luv2code.springboot.cruddemo.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service

public class TeacherDTOMapper implements Function<Teacher, TeacherDTO> {

    public TeacherDTO apply(Teacher teacher) {
        return new TeacherDTO(
                teacher.getId(),
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getAge(),
                teacher.getAddresses().stream()
                        .map(address -> new AddressDTO(
                                address.getId(),
                                address.getStreetName(),
                                address.getCountry(),
                                address.getGovernment()
                        ))
                        .collect(Collectors.toSet())
        );
    }
}
