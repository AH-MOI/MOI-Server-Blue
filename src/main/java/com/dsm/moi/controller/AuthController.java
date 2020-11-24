package com.dsm.moi.controller;

import com.dsm.moi.domains.domain.Student;
import com.dsm.moi.domains.service.AuthService;
import com.dsm.moi.utils.exception.RuleViolationInformationException;
import com.dsm.moi.utils.form.JoinRequestForm;
import com.dsm.moi.utils.form.LoginRequestForm;
import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
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
    public void login(@RequestBody LoginRequestForm form) {

    }

    @PostMapping(value = "/token")
    public void isUsableToken() {

    }

    @GetMapping(value = "/access-token")
    public void tokenIssuance() {

    }
}
