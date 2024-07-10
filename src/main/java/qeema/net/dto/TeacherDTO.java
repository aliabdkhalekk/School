package qeema.net.dto;


import java.util.Set;

public record TeacherDTO(
        int id,
        String firstName,
        String lastName,
        int age,
        Set<AddressDTO> addresses
) {}