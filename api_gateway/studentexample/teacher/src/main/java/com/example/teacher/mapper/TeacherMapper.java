package com.example.teacher.mapper;

import com.example.teacher.dto.TeacherDto;
import com.example.teacher.model.Teacher;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class TeacherMapper {

    private static ModelMapper mapper = new ModelMapper();

    public static TeacherDto toTeacherDto(Teacher teacher) {
        return mapper.map(teacher, TeacherDto.class);
    }


    public static Teacher toTeacher(TeacherDto teacherDto) {
        return mapper.map(teacherDto, Teacher.class);
    }


    public static List<TeacherDto> toTeacherDtos(List<Teacher> Teachers) {
        return Teachers.stream().map(Teacher -> toTeacherDto(Teacher)).collect(Collectors.toList());
    }

    public static List<Teacher> toTeachers(List<TeacherDto> TeacherDtos) {
        return TeacherDtos.stream().map(TeacherDto -> toTeacher(TeacherDto)).collect(Collectors.toList());
    }

}
