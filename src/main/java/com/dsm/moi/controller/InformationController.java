package com.dsm.moi.controller;

import com.dsm.moi.domains.domain.Student;
import com.dsm.moi.domains.service.JwtService;
import com.dsm.moi.domains.service.StudentService;
import com.dsm.moi.utils.exception.TokenInvalidException;
import com.dsm.moi.utils.form.StudentInformationRequestForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/info")
public class InformationController {

    private StudentService studentService;
    private JwtService jwtService;

    @Autowired
    public InformationController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PutMapping("/student")
    public void changeStudentInformation(HttpServletRequest request, @RequestBody StudentInformationRequestForm form) {
        String authorization = request.getHeader("Authorization");
        tokenValidation(authorization);

        Student student = new Student();
        student.setId(jwtService.getStudentId(authorization));
        student.setPhoneNumber(form.getPhoneNumber());
        student.setArea(form.getArea());
        student.setGithub(form.getGithub());
        student.setHashtag(form.getHashtag());
        student.setProfile(form.getProfile());

        studentService.updateStudentInformation(student);
    }

    private void tokenValidation(String token) {
        boolean isValid = jwtService.isValid(token);
        boolean isNotTimeOut = jwtService.isNotTimeOut(token);

        if(!(isValid && isNotTimeOut))
            throw new TokenInvalidException();
    }
}