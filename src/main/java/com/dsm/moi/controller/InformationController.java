package com.dsm.moi.controller;

import com.dsm.moi.domains.domain.Student;
import com.dsm.moi.domains.service.JwtService;
import com.dsm.moi.domains.service.ProjectService;
import com.dsm.moi.domains.service.StudentService;
import com.dsm.moi.utils.exception.TokenInvalidException;
import com.dsm.moi.utils.form.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/info")
public class InformationController {

    private static final Logger log = LoggerFactory.getLogger(InformationController.class);

    private final StudentService studentService;
    private final ProjectService projectService;
    private final JwtService jwtService;

    @Autowired
    public InformationController(StudentService studentService, JwtService jwtService, ProjectService projectService) {
        this.studentService = studentService;
        this.jwtService = jwtService;
        this.projectService = projectService;
    }

    @PatchMapping("/participation/project")
    public void participatingProject(HttpServletRequest request, @RequestBody ParticipatingProjectRequestForm form) {

        log.info("PATCH /info/participation/project");

        String authorization = request.getHeader("Authorization");
        tokenValidation(authorization);

        studentService.acceptProject(form.getAppliedStudentId(), form.getProjectId());
    }

    @GetMapping("/project")
    public ParticipatingProjectLastResponseForm getMyProject(HttpServletRequest request) {

        log.info("GET /info/project");

        String authorization = request.getHeader("Authorization");
        tokenValidation(authorization);

        String studentId = jwtService.getStudentId(authorization);
        return new ParticipatingProjectLastResponseForm(projectService.getMyProject(studentId));
    }

    @GetMapping("/participation/project")
    public ParticipatingProjectLastResponseForm getParticipatingProject(HttpServletRequest request) {

        log.info("GET /info/participation/project");

        String authorization = request.getHeader("Authorization");
        tokenValidation(authorization);

        String studentId = jwtService.getStudentId(authorization);
        return new ParticipatingProjectLastResponseForm(projectService.getParticipatingProject(studentId));
    }

    @GetMapping("project/{projectId}")
    public MyProjectDetailForm getMyProjectDetail(HttpServletRequest request, @PathVariable("projectId") String projectId) {

        log.info(String.format("GET /info/project/%s", projectId));

        String authorization = request.getHeader("Authorization");
        tokenValidation(authorization);

        String studentId = jwtService.getStudentId(authorization);
        return projectService.getMyProjectDetail(studentId, projectId);
    }

    @GetMapping("project/participation/{projectId}")
    public ParticipatingProjectDetailForm getParticipatingProjectDetail(HttpServletRequest request, @PathVariable("projectId") String projectId) {

        log.info(String.format("GET /info/project/participation/%s", projectId));

        String authorization = request.getHeader("Authorization");
        tokenValidation(authorization);

        String studentId = jwtService.getStudentId(authorization);
        return projectService.getParticipatingProjectDetail(studentId, projectId);
    }

    @GetMapping("/student")
    public StudentInformationResponseForm getStudentInformation(HttpServletRequest request) {

        log.info("GET /info/student");

        String authorization = request.getHeader("Authorization");
        tokenValidation(authorization);

        String studentId = jwtService.getStudentId(authorization);
        Student findStudent = studentService.getStudentById(studentId);

        return new StudentInformationResponseForm(findStudent.getId(), findStudent.getName(), findStudent.getBirthday(),
                findStudent.getSchool(), findStudent.getProfile(), findStudent.getGithub(), findStudent.getPhoneNumber(),
                findStudent.getArea(), findStudent.getHashtag(), findStudent.getStar(), findStudent.getIntroduce());
    }

    @PatchMapping("/student")
    public void changeStudentInformation(HttpServletRequest request, @RequestBody StudentInformationRequestForm form) {

        log.info("PATCH /info/student");

        String authorization = request.getHeader("Authorization");
        tokenValidation(authorization);

        Student student = new Student();
        student.setId(jwtService.getStudentId(authorization));
        student.setPhoneNumber(form.getPhoneNumber());
        student.setArea(form.getArea());
        student.setGithub(form.getGithub());
        student.setHashtag(form.getHashtag());
        student.setProfile(form.getProfile());
        student.setIntroduce(form.getIntroduce());

        studentService.updateStudentInformation(student);
    }

    @GetMapping("/all-student")
    public AllStudentResponseForm getAllStudent(HttpServletRequest request) {

        log.info("GET /info/all-student");

        return new AllStudentResponseForm(studentService.getAllStudents());
    }

    private void tokenValidation(String token) {
        boolean isValid = jwtService.isValid(token);
        boolean isNotTimeOut = jwtService.isNotTimeOut(token);

        if(!(isValid && isNotTimeOut))
            throw new TokenInvalidException();
    }
}