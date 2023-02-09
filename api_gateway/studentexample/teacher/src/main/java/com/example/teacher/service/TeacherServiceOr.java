package com.example.teacher.service;

import com.example.common.dto.TeacherDto;
import com.example.common.model.Teacher;

import java.util.List;

public interface TeacherServiceOr {

    TeacherDto getTeacherById(long id);

    Teacher findById(long id);

    TeacherDto addTeacher(TeacherDto teacherDto);

    List<TeacherDto> getAllTeacher();

}
