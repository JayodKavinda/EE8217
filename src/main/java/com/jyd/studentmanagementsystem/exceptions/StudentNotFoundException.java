package com.jyd.studentmanagementsystem.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
public class StudentNotFoundException extends RuntimeException {


    private long id;

    public StudentNotFoundException( long id) {
        super(String.format("Student not found with %s", id));
        this.id = id;
    }
}
