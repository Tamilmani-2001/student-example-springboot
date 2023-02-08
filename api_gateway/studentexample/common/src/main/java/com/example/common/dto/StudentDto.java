package com.example.common.dto;

import com.example.common.constants.Constants;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    @JsonProperty(access = Access.READ_ONLY)
    private long id;

    @NotBlank
    @Pattern(regexp = Constants.NAME_PATTERN)
    private String name;

    @NotBlank
    @Pattern(regexp = Constants.ROLL_NO_PATTERN)
    private String rollNo;

    @NotBlank
    @Pattern(regexp = Constants.PHONE_NO_PATTERN)
    private String phoneNumber;

    @NotBlank
    @Pattern(regexp = Constants.GENDER_PATTERN)
    private String gender;

    @NotBlank
    @Pattern(regexp = Constants.NAME_PATTERN)
    private String schoolName;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Min(value = 1)
    private long refId;

    @JsonProperty(access = Access.READ_ONLY)
    private long createdBy;

    @JsonProperty(access = Access.READ_ONLY)
    private LocalDateTime createdAt;

    @JsonProperty(access = Access.READ_ONLY)
    private long updatedBy;

    @JsonProperty(access = Access.READ_ONLY)
    private LocalDateTime updateAt;
}
