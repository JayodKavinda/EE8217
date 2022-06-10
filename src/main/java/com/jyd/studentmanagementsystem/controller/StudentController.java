package com.jyd.studentmanagementsystem.controller;

import com.jyd.studentmanagementsystem.entity.Student;
import com.jyd.studentmanagementsystem.payload.StudentDto;
import com.jyd.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("api/student")
    public ResponseEntity<StudentDto> createCourse(@Valid @RequestBody StudentDto studentDto){

        return new ResponseEntity<>(studentService.createStudent(studentDto), HttpStatus.CREATED);
    }

    @GetMapping("api/student")
    public ResponseEntity<List<StudentDto>> getAllStudent(){

        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.CREATED);
    }
}
