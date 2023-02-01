package com.example.teacher.service;

import com.example.teacher.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:8080/api/v1/students", name = "TECHER-SERVICE")
public interface TeacherService {

    @GetMapping
    List<StudentDto> getAllStudents();

    @GetMapping("/{id}")
    StudentDto getStudentById(@PathVariable long id);

}
