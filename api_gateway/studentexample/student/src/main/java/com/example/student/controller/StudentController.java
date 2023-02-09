package com.example.student.controller;

import com.example.common.constants.Constants;
import com.example.common.dto.StudentDto;
import com.example.common.exception.StudentException;
import com.example.student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<StudentDto> getStudentById(@PathVariable String id) {
        long newId = 0;
        try {
            newId = Long.parseLong(id);
        } catch (NumberFormatException errorInId) {
            throw new StudentException(Constants.INVALID_ID);
        }
        return new ResponseEntity<StudentDto>(studentService.getStudentById(newId), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    private ResponseEntity<List<StudentDto>> getAllStudentByName(@PathVariable String name) {
        return new ResponseEntity<List<StudentDto>>(studentService.getAllStudentsByName(name), HttpStatus.ACCEPTED);
    }

    @GetMapping
    private ResponseEntity<List<StudentDto>> getAllStudent() {
        return new ResponseEntity<List<StudentDto>>(studentService.getAllStudent(), HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity updateById(@PathVariable long id, @RequestBody @Valid StudentDto studentDto) {
        studentService.updateById(id, studentDto);
        return new ResponseEntity(Constants.UPDATE_MSG, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<StudentDto> addStudent(@RequestBody @Valid StudentDto studentDto) {
        return new ResponseEntity<StudentDto>(studentService.addStudent(studentDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity deleteById(@PathVariable long id) {
        studentService.deleteById(id);
        return new ResponseEntity(Constants.DELETE_MSG, HttpStatus.OK);
    }
}
