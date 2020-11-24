package com.dsm.moi.controller;

import com.dsm.moi.domains.domain.Student;
import com.dsm.moi.domains.service.AuthService;
import com.dsm.moi.domains.service.JwtService;
import com.dsm.moi.domains.service.StudentService;
import com.dsm.moi.utils.exception.AccountNotFoundException;
import com.dsm.moi.utils.exception.RuleViolationInformationException;
import com.dsm.moi.utils.exception.TokenInvalidException;
import com.dsm.moi.utils.form.AccessTokenResponseForm;
import com.dsm.moi.utils.form.JoinRequestForm;
import com.dsm.moi.utils.form.LoginRequestForm;
import com.dsm.moi.utils.form.LoginResponseForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private AuthService authService;
    private JwtService jwtService;
    private StudentService studentService;

    @Autowired
    public AuthController(AuthService authService, JwtService jwtService, StudentService studentService) {
        this.authService = authService;
        this.jwtService = jwtService;
        this.studentService = studentService;
    }

    @PostMapping(value = "/join")
    public void join(@RequestBody JoinRequestForm form) {
        Student student = new Student();

        student.setId(form.getId());
        student.setPassword(form.getPassword());
        student.setName(form.getName());
        student.setBirthday(form.getBirthday());
        student.setSchool(form.getSchool());

        if(!student.isNormalInformation())
            throw new RuleViolationInformationException();
        if(authService.samePassword(student.getPassword(), form.getConfirmPassword()))
            throw new RuleViolationInformationException();
        student.setPassword(authService.encodingPassword(student.getPassword()));

        authService.join(student);
    }

    @PostMapping(value = "/login")
    public LoginResponseForm login(@RequestBody LoginRequestForm form) {
        String id = form.getId();
        String password = form.getPassword();

        Student student = new Student();
        student.setId(id);
        student.setPassword(password);
        if(student.existIdPassword())
            throw new RuleViolationInformationException();

        Student findStudent = studentService.getStudentById(id);
        if(!student.equals(findStudent))
            throw new AccountNotFoundException();

        String accessToken = jwtService.createToken(id, 1000 * 60 * 30);                    // 30분 - AccessToken
        String refreshToken = jwtService.createToken(id, 1000 * 60 * 60 * 24 * 7);          // 2주 - RefreshToken
        return new LoginResponseForm(accessToken, refreshToken);
    }

    @PostMapping(value = "/token")
    public void isUsableToken(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");

        if(!(jwtService.isValid(authorization) && jwtService.isNotTimeOut(authorization)))
            throw new TokenInvalidException();
    }

    @GetMapping(value = "/access-token")
    public AccessTokenResponseForm tokenIssuance(HttpServletRequest request) {
        String refreshToken = request.getHeader("Authorization");

        if(!(jwtService.isValid(refreshToken) && jwtService.isNotTimeOut(refreshToken)))
            throw new TokenInvalidException();

        String studentId = jwtService.getStudentId(refreshToken);
        String accessToken = jwtService.createToken(studentId, 1000 * 60 * 30);
        return new AccessTokenResponseForm(accessToken);
    }
}
