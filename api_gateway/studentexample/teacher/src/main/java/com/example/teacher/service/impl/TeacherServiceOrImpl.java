package com.example.teacher.service.impl;

import com.example.teacher.constants.Constants;
import com.example.teacher.dto.TeacherDto;
import com.example.teacher.exception.StudentException;
import com.example.teacher.mapper.TeacherMapper;
import com.example.teacher.model.Teacher;
import com.example.teacher.repository.TeacherRepository;
import com.example.teacher.service.TeacherServiceOr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceOrImpl implements TeacherServiceOr {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public TeacherDto getTeacherById(long id) {
        return TeacherMapper.toTeacherDto(findById(id));
    }

    @Override
    public Teacher findById(long id) {
        Optional<Teacher> student = teacherRepository.findById(id);
        if (student.isEmpty()) {
            throw new StudentException(Constants.TEACHER_NOT_FOUND);
        }
        return student.get();
    }

    public TeacherDto addTeacher(TeacherDto teacherDto) {
        Teacher teacher;
        if (null == teacherDto) {
            throw new StudentException(Constants.TEACHER_DETAILS_EMPTY_MSG);
        }
        if (teacherRepository.findByRollNo(teacherDto.getRollNo()).isPresent()) {
            throw new StudentException(Constants.ROLLNO_ALREADY_PRESENT_MSG);
        }
        teacher = TeacherMapper.toTeacher(teacherDto);
        teacher.setCreatedBy(teacherDto.getRefId());
        teacher.setCreatedAt(LocalDateTime.now());
        teacher.setUpdatedBy(teacherDto.getRefId());
        teacher.setUpdateAt(teacher.getCreatedAt());
        return TeacherMapper.toTeacherDto(teacherRepository.save(teacher));
    }

    @Override
    public List<TeacherDto> getAllTeacher() {
        List<Teacher> teachers = teacherRepository.findAll();
        return TeacherMapper.toTeacherDtos(teachers);
    }

}
