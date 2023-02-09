package com.example.common.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Data
@Entity
@Where(clause = "is_deleted = false")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    private String rollNo;

    private String phoneNumber;

    private String gender;

    private String schoolName;

    private long createdBy;

    private LocalDateTime createdAt;

    private long updatedBy;

    private LocalDateTime updateAt;

    private boolean isDeleted;
}
