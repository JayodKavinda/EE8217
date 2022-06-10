package com.jyd.studentmanagementsystem.service;

import com.jyd.studentmanagementsystem.entity.Student;
import com.jyd.studentmanagementsystem.payload.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);
    List<StudentDto> getAllStudents();
    void deleteStudent(long id);

}
