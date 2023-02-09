package com.example.common.mapper;


import com.example.common.dto.StudentDto;
import com.example.common.dto.TeacherDto;
import com.example.common.model.Student;
import com.example.common.model.Teacher;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class StudentMapper {

    private static ModelMapper mapper = new ModelMapper();

    public static StudentDto toStudentDto(Student student) {
        return mapper.map(student, StudentDto.class);
    }

    public static Student toStudent(StudentDto studentDto) {
        return mapper.map(studentDto, Student.class);
    }


    public static List<StudentDto> toStudentDtos(List<Student> students) {
        return students.stream().map(student -> toStudentDto(student)).collect(Collectors.toList());
    }

    public static List<Student> toStudents(List<StudentDto> studentDtos) {
        return studentDtos.stream().map(studentDto -> toStudent(studentDto)).collect(Collectors.toList());
    }


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
