package com.jyd.studentmanagementsystem.service.impl;

import com.jyd.studentmanagementsystem.entity.Student;
import com.jyd.studentmanagementsystem.exceptions.StudentNotFoundException;
import com.jyd.studentmanagementsystem.payload.StudentDto;
import com.jyd.studentmanagementsystem.repository.StudentRepository;
import com.jyd.studentmanagementsystem.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository repository;
    private ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = mapToEntity(studentDto);
        repository.save(student);
        return studentDto;
    }



    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = repository.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        for(Student student: students){
            studentDtos.add(mapToDto(student));
        }
        return studentDtos;
    }

    @Override
    public void deleteStudent(long id) {
        Student student = repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        repository.delete(student);

    }

    private Student mapToEntity(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        return student;
    }

    private StudentDto mapToDto(Student student) {
        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        return studentDto;
    }
}
