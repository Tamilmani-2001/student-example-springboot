package com.example.teacher.service;

import com.example.teacher.dto.TeacherDto;
import com.example.teacher.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TeacherServiceOr {

    TeacherDto getTeacherById(long id);

    Teacher findById(long id);

    TeacherDto addTeacher(TeacherDto teacherDto);

    List<TeacherDto> getAllTeacher();

}
