package com.example.student.service;

import com.example.common.dto.StudentDto;
import com.example.common.model.Student;

import java.util.List;

public interface StudentService {

    StudentDto addStudent(StudentDto studentDto);

    StudentDto getStudentById(long id);

    List<StudentDto> getAllStudentsByName(String name);

    List<StudentDto> getAllStudent();

    void updateById(long id, StudentDto studentDto);

    void deleteById(long id);

    Student findById(long id);
}
