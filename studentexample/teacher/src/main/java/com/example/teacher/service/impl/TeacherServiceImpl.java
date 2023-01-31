package com.example.teacher.service.impl;

import com.example.student.dto.StudentDto;
import com.example.student.service.StudentService;
import com.example.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private StudentService studentService;

    @Autowired
    private TeacherServiceImpl(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public StudentDto getStudentById(long id) {
        return studentService.getStudentById(id);
    }

    @Override
    public List<StudentDto> getAllStudent() {
        return studentService.getAllStudent();
    }

}
