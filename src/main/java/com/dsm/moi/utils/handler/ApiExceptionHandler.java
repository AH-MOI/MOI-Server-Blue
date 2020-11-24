package com.dsm.moi.utils.handler;

import com.dsm.moi.utils.exception.NonExistAccountException;
import com.dsm.moi.utils.exception.RuleViolationInformationException;
import com.dsm.moi.utils.form.ApiErrorResponseForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(RuleViolationInformationException.class)
    public ResponseEntity<ApiErrorResponseForm> ruleViolationInformationExceptionHandler(RuleViolationInformationException ex) {
        ApiErrorResponseForm response = new ApiErrorResponseForm("회원의 정보가 잘못되었습니다.", "회원의 정보가 잘못되었습니다.");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NonExistAccountException.class)
    public ResponseEntity<ApiErrorResponseForm> nonExistAccountException(NonExistAccountException ex) {
        ApiErrorResponseForm response = new ApiErrorResponseForm("일치하는 계정을 찾을 수 없습니다.", "일치하는 계정을 찾을 수 없습니다.");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
