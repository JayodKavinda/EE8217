package com.jyd.studentmanagementsystem.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class StudentDto {

    private long id;
    @NotEmpty
    @Size(min = 2, message = "Fist Name should have at least 2 characters")
    private String firstName;
    @NotEmpty
    @Size(min = 2, message = "Last Name should have at least 2 characters")
    private String lastName;
    @NotEmpty
    @Size(min = 2, message = "Faculty should have at least 2 characters")
    private String faculty;

    private double gpa;
}
