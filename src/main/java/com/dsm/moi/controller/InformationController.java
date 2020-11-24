package com.dsm.moi.controller;

import com.dsm.moi.domains.domain.Student;
import com.dsm.moi.domains.service.JwtService;
import com.dsm.moi.domains.service.ProjectService;
import com.dsm.moi.domains.service.StudentService;
import com.dsm.moi.utils.exception.TokenInvalidException;
import com.dsm.moi.utils.form.StudentInformationRequestForm;
import com.dsm.moi.utils.form.StudentInformationResponseForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/info")
public class InformationController {

    private StudentService studentService;
    private ProjectService projectService;
    private JwtService jwtService;

    @Autowired
    public InformationController(StudentService studentService, JwtService jwtService, ProjectService projectService) {
        this.studentService = studentService;
        this.jwtService = jwtService;
        this.projectService = projectService;
    }

    @GetMapping("/participation/project")
    public void getProject(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        tokenValidation(authorization);

        String studentId = jwtService.getStudentId(authorization);
        projectService.getParticipatingProject(studentId);
    }

    @GetMapping("/student")
    public StudentInformationResponseForm getStudentInformation(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        tokenValidation(authorization);

        String studentId = jwtService.getStudentId(authorization);
        Student findStudent = studentService.getStudentById(studentId);

        return new StudentInformationResponseForm(findStudent.getId(), findStudent.getName(), findStudent.getBirthday(),
                findStudent.getSchool(), findStudent.getArea(), findStudent.getProfile(), findStudent.getGithub(),
                findStudent.getPhoneNumber(), findStudent.getHashtag());
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