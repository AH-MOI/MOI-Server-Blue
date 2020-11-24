package com.dsm.moi.controller;

import com.dsm.moi.domains.domain.Student;
import com.dsm.moi.domains.service.AuthService;
import com.dsm.moi.utils.exception.RuleViolationInformationException;
import com.dsm.moi.utils.form.JoinRequestForm;
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

        if(!student.isNormalInformation())
            throw new RuleViolationInformationException();

        student.setId(form.getId());
        student.setPassword(form.getPassword());
        student.setName(form.getName());
        student.setBirthday(form.getBirthday());
        student.setSchool(form.getSchool());

        authService.join(student);
    }

    @PostMapping(value = "/login")
    public void login() {

    }

    @PostMapping(value = "/token")
    public void isUsableToken() {

    }

    @GetMapping(value = "/access-token")
    public void tokenIssuance() {

    }
}
