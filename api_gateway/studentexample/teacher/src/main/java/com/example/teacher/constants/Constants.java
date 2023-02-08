package com.example.teacher.constants;

public class Constants {

    //Regex patterns
    public static final String GENDER_PATTERN = "(?i)^(male)|(female)|(others)$";
    public static final String NAME_PATTERN = "([a-zA-Z][ ]?){2,50}";
    public static final String PHONE_NO_PATTERN = "^(\\+91|0)?[6789][0-9]{9}$";
    public static final String ROLL_NO_PATTERN = "^[0-9]{2}[a-zA-Z]{3}[0-9]{2}$";

    //Regex invalid patterns messages.
    public static final String INVALID_NAME_PATTERN_MSG = "Name is should be match in the pattern of ([a-zA-Z][ ]?){2,50} ex.abdul";
    public static final String INVALID_ROLL_NO_PATTERN_MSG = "Roll no is should be match in the pattern of [0-9]{2}[a-zA-Z]{3}[0-9]{2} ex.12ABC34";
    public static final String INVALID_PHONE_NO_PATTERN_MSG = "Phone number is should be match in the pattern of (\\+91|0)?[6789][0-9]{9} ex.9898989898";
    public static final String INVALID_GENDER_PATTERN_MSG = "Gender is should be match in the pattern of (male)|(female)|(others)";
    public static final String INVALID_ID = "Id should be in numbers.";

    //Other messages.
    public static final String TEACHER_DETAILS_EMPTY_MSG = "teacher details is empty.";
    public static final String ROLLNO_ALREADY_PRESENT_MSG = "Roll number is already present.";
    public static final String TEACHER_NOT_FOUND = "teacher not found.";
    public static final String UPDATE_MSG = "Updated successfully";
    public static final String DELETE_MSG = "Deleted successfully.";

}
