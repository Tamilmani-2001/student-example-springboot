package com.example.teacher.controller;

import com.example.common.constants.Constants;
import com.example.common.dto.StudentDto;
import com.example.common.dto.TeacherDto;
import com.example.common.exception.StudentException;
import com.example.teacher.service.TeacherService;
import com.example.teacher.service.TeacherServiceOr;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherServiceOr teacherServiceOr;

    @GetMapping("/students")
    private List<StudentDto> getAllStudents() {
        return teacherService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    private ResponseEntity<StudentDto> getStudentById(@PathVariable long id) {
        return new ResponseEntity<>(teacherService.getStudentById(id), HttpStatus.OK);
    }


//    @GetMapping("/students/{id}")
//    private ResponseEntity getStudentById(@PathVariable long id) {
//        ResponseEntity entityResponse = teacherService.getStudentById(id);
//        System.out.println(entityResponse.toString());
//        return entityResponse;
//    }

    @GetMapping("/{id}")
    private ResponseEntity<TeacherDto> getTeacherById(@PathVariable String id) {
        long newId = 0;
        try {
            newId = Long.parseLong(id);
        } catch (NumberFormatException errorInId) {
            throw new StudentException(Constants.INVALID_ID);
        }
        return new ResponseEntity<TeacherDto>(teacherServiceOr.getTeacherById(newId), HttpStatus.OK);
    }


    @GetMapping
    private ResponseEntity<List<TeacherDto>> getAllTeacher() {
        return new ResponseEntity<List<TeacherDto>>(teacherServiceOr.getAllTeacher(), HttpStatus.ACCEPTED);
    }

    @PostMapping
    private ResponseEntity<TeacherDto> addStudent(@RequestBody @Valid TeacherDto teacherDto) {
        return new ResponseEntity<TeacherDto>(teacherServiceOr.addTeacher(teacherDto), HttpStatus.ACCEPTED);
    }


}
