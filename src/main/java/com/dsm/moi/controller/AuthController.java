package com.dsm.moi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @PostMapping(value = "/join")
    public void join() {

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
