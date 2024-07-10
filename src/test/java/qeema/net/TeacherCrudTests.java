package qeema.net;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import qeema.net.dao.TeacherRepository;
import qeema.net.dto.AddressDTO;
import qeema.net.dto.TeacherDTO;
import qeema.net.entity.Address;
import qeema.net.entity.Teacher;
import qeema.net.service.TeachersServiceImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class TeacherCrudTests {

    @MockBean
    private TeacherRepository teacherRepository;

    @Autowired
    private TeachersServiceImpl teacherService;

    private Teacher teacher;
    private TeacherDTO teacherDTO;
    private Address address;
    private AddressDTO addressDTO;

    @BeforeEach
    void setUp() {
        address = new Address(1, "Street 1", "Country 1", "Government 1", null);
        teacher = new Teacher(1, "ali", "ahmed", 30, address);
        addressDTO = new AddressDTO(1, "Street 1", "Country 1", "Government 1");
        teacherDTO = new TeacherDTO(1, "ali", "ahmed", 30, Collections.singleton(addressDTO));
    }

    @Test
    void findByIdTest() {
        when(teacherRepository.findById(1)).thenReturn(Optional.of(teacher));
        TeacherDTO result = teacherService.findById(1);
        assertNotNull(result);
        assertEquals("ali", result.firstName());
    }

    @Test
    void NotfoundByIdTest() {
        when(teacherRepository.findById(100)).thenReturn(Optional.empty());
        Exception exception= assertThrows(RuntimeException.class, () -> teacherService.findById(100));
        assertTrue(exception.getMessage().contains("Did not find teacher id : "));
    }

    @Test
    void findAllTest() {
        Address address1 = new Address(1, "Street 1", "Country 1", "Government 1", null);
        Teacher teacher1 = new Teacher(1, "ali", "ahmed", 30, address);
        AddressDTO addressDTO1 = new AddressDTO(1, "Street 1", "Country 1", "Government 1");
        TeacherDTO teacherDTO1 = new TeacherDTO(1, "ali", "ahmed", 30, Collections.singleton(addressDTO));

        Address address2 = new Address(2, "Street 2", "Country 2", "Government 2", null);
        Teacher teacher2 = new Teacher(1, "samer", "mostafa", 23, address);
        AddressDTO addressDTO2 = new AddressDTO(1, "Street 2", "Country 2", "Government 2");
        TeacherDTO teacherDTO2 = new TeacherDTO(1, "samer", "mostafa", 23, Collections.singleton(addressDTO));


        when(teacherRepository.findAll()).thenReturn(Arrays.asList(teacher1, teacher2));


        List<TeacherDTO> teachers = teacherService.findAll();

        assertEquals(2, teachers.size());
        assertEquals("ali", teachers.get(0).firstName());
        assertEquals("mostafa", teachers.get(1).lastName());
    }

    @Test
    void testSave() {
		Address address1 = new Address(1, "Street 1", "Country 1", "Government 1", null);
		Teacher teacher1 = new Teacher(1, "ali", "ahmed", 30, address);
		AddressDTO addressDTO1 = new AddressDTO(1, "Street 1", "Country 1", "Government 1");
		TeacherDTO teacherDTO1 = new TeacherDTO(1, "ali", "ahmed", 30, Collections.singleton(addressDTO));

		when(teacherRepository.save(any(Teacher.class))).thenReturn(teacher);

        TeacherDTO savedTeacherDTO = teacherService.save(teacherDTO);

        assertNotNull(savedTeacherDTO);
        assertEquals("ali", savedTeacherDTO.firstName());
    }

    @Test
    void deleteByIdTest() {
        when(teacherRepository.existsById(1)).thenReturn(true);
        doNothing().when(teacherRepository).deleteById(1);
        teacherService.deleteById(1);
        verify(teacherRepository, times(1)).deleteById(1);
    }



}
