package com.example.springBootProject.controller;

import com.example.springBootProject.dtos.StudentDTO;
import com.example.springBootProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
        studentService.add(studentDTO);
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }



}
