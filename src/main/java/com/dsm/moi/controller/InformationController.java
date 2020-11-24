package com.dsm.moi.controller;

import com.dsm.moi.domains.domain.Student;
import com.dsm.moi.domains.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InformationController {

    private StudentService studentService;

    @Autowired
    public InformationController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PutMapping("/student")
    public void changeStudentInformation(@RequestBody Student student) {
        studentService.updateStudentInformation(student);
    }
}