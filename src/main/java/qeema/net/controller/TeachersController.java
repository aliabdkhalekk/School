package qeema.net.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import qeema.net.dto.TeacherDTO;
import qeema.net.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/teacherses")
public class TeachersController {
    private static final Logger logger = LogManager.getLogger(TeachersController.class);

    private  final TeacherService teacherService;



    @Operation(summary = "get all teachers ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "return teachers "),
            @ApiResponse(responseCode = "404",description = " teachers not found  ")
    })
    @GetMapping
    public ResponseEntity<List<TeacherDTO>> getAllTeachers() {
        logger.info("Fetching all teachers");
        List<TeacherDTO> teachers = teacherService.findAll();
        return ResponseEntity.ok(teachers);
    }

    @Operation(summary = "get teacher by id  ")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200",description = "return teacher "),
            @ApiResponse(responseCode = "404",description = " teacher not found  ")
    })
    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable int id) {
        logger.info("Fetching teacher with id: {}", id);
        TeacherDTO teacher = teacherService.findById(id);
        return ResponseEntity.ok(teacher);
    }

    @Operation(summary = "delete teacher by id  ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = " teacher deleted "),

    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacherById(@PathVariable int id) {
        logger.info("Deleting teacher with id: {}", id);
        teacherService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "get all teachers ")
    @ApiResponse(responseCode = "201",description = "create new teacher sucsess")
    @PostMapping
    public ResponseEntity<TeacherDTO> createTeachers(@RequestBody TeacherDTO teacher) {
        logger.info("Creating new teacher: {}", teacher);
        TeacherDTO savedTeacher = teacherService.save(teacher);
        return ResponseEntity.ok(savedTeacher);
    }

    @Operation(summary = "update teacher by id  ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "return teacher "),
            @ApiResponse(responseCode = "404",description = " teacher not found  ")
    })
    @PutMapping
    public ResponseEntity<TeacherDTO> updateTeacher(@RequestBody TeacherDTO teacher) {
        logger.info("Updating teacher with id: {}", teacher.id());
        TeacherDTO updatedTeacher = teacherService.save(teacher);
        return ResponseEntity.ok(updatedTeacher);
    }
}
