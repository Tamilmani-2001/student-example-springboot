package com.example.teacher.controller;

import com.example.teacher.service.TeacherService;
import com.example.teacher.dto.StudentDto;
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
    @Autowired
    private TeacherService teacherService;
    @GetMapping("/students")
    private List<StudentDto> getAllStudents() {
        return teacherService.getAllStudents();
    }
    @GetMapping("/students/{id}")
    private ResponseEntity<StudentDto> getStudentById(@PathVariable long id) {
        return new ResponseEntity<>(teacherService.getStudentById(id), HttpStatus.OK);
    }

}
