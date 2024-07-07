package com.luv2code.springboot.cruddemo.dto;

import com.luv2code.springboot.cruddemo.entity.Address;
import com.luv2code.springboot.cruddemo.entity.Teacher;

import java.util.Set;
import java.util.stream.Collectors;

public class TeacherDTOConverter {


        public static Teacher toTeacherEntity(TeacherDTO teacherDTO) {
            Teacher teacher = new Teacher();
            teacher.setId(teacherDTO.id());
            teacher.setFirstName(teacherDTO.firstName());
            teacher.setLastName(teacherDTO.lastName());
            teacher.setAge(teacherDTO.age());

            Set<Address> addresses = teacherDTO.addresses().stream()
                    .map(TeacherDTOConverter::toAddressEntity)
                    .collect(Collectors.toSet());
            teacher.setAddresses(addresses);

            return teacher;
        }

        public static Address toAddressEntity(AddressDTO addressDTO) {
            Address address = new Address();
            address.setId(addressDTO.id());
            address.setStreetName(addressDTO.streetName());
            address.setCountry(addressDTO.country());
            address.setGovernment(addressDTO.government());
            return address;
        }
    }

