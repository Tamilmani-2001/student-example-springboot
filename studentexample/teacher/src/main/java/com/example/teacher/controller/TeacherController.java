package com.example.teacher.controller;

import com.example.student.constants.Constants;
import com.example.student.dto.StudentDto;
import com.example.student.exception.StudentException;
import com.example.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    private TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping(value = "/student/{id}")
    private ResponseEntity<StudentDto> getStudentById(@PathVariable String id) {
        long newId = 0;
        try {
            newId = Long.parseLong(id);
        } catch (NumberFormatException errorInId) {
            throw new StudentException(Constants.INVALID_ID);
        }
        return new ResponseEntity<StudentDto>(teacherService.getStudentById(newId), HttpStatus.OK);
    }

    @GetMapping(value = "/students")
    private ResponseEntity<List<StudentDto>> getAllStudent() {
        return new ResponseEntity<List<StudentDto>>(teacherService.getAllStudent(), HttpStatus.ACCEPTED);
    }

}
