package com.example.teacher.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StudentDto {

    private long id;

    private String name;

    private String rollNo;

    private String phoneNumber;

    private String gender;

    private String schoolName;

    private long refId;

    private long createdBy;

    private LocalDateTime createdAt;

    private long updatedBy;

    private LocalDateTime updateAt;
}
