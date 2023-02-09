package com.example.student.service.impl;

import com.example.common.constants.Constants;
import com.example.common.dto.StudentDto;
import com.example.common.exception.StudentException;
import com.example.common.mapper.StudentMapper;
import com.example.common.model.Student;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    private StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto addStudent(StudentDto studentDto) {
        Student student;
        if (null == studentDto) {
            throw new StudentException(Constants.STUDENT_DETAILS_EMPTY_MSG);
        }
        if (studentRepository.findByRollNo(studentDto.getRollNo()).isPresent()) {
            throw new StudentException(Constants.ROLLNO_ALREADY_PRESENT_MSG);
        }
        student = StudentMapper.toStudent(studentDto);
        student.setCreatedBy(studentDto.getRefId());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedBy(studentDto.getRefId());
        student.setUpdateAt(student.getCreatedAt());
        return StudentMapper.toStudentDto(studentRepository.save(student));
    }

    @Override
    public StudentDto getStudentById(long id) {
        return StudentMapper.toStudentDto(findById(id));
    }

    public Student findById(long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new StudentException(Constants.STUDENT_NOT_FOUND);
        }
        return student.get();
    }

    @Override
    public List<StudentDto> getAllStudentsByName(String name) throws StudentException {
        List<Student> students = studentRepository.findByName(name.toLowerCase());
        if (students.isEmpty()) {
            throw new StudentException(Constants.STUDENT_NOT_FOUND);
        }
        return StudentMapper.toStudentDtos(students);
    }

    @Override
    public List<StudentDto> getAllStudent() {
        Pageable pageable = PageRequest.of(0, 4);
        List<Student> students = studentRepository.findAll(pageable).toList();
        return StudentMapper.toStudentDtos(students);
    }

    @Override
    public void updateById(long id, StudentDto studentDto) {
        Student student = findById(id);
        Student newStudent = StudentMapper.toStudent(studentDto);
        newStudent.setId(student.getId());
        newStudent.setCreatedBy(student.getCreatedBy());
        newStudent.setCreatedAt(student.getCreatedAt());
        newStudent.setUpdatedBy(studentDto.getRefId());
        newStudent.setUpdateAt(LocalDateTime.now());
        studentRepository.save(newStudent);
    }

    @Override
    public void deleteById(long id) {
        Student student = findById(id);
        student.setDeleted(true);
        studentRepository.save(student);
    }
}
