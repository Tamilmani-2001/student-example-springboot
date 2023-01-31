package com.example.student.mapper;

import com.example.student.dto.StudentDto;
import com.example.student.model.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

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

}
