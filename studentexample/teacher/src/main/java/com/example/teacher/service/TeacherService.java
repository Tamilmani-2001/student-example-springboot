package com.example.teacher.service;

import com.example.student.dto.StudentDto;
import com.example.student.exception.StudentException;
import com.example.student.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TeacherService {

    StudentDto getStudentById(long id);

    List<StudentDto> getAllStudent();

}
