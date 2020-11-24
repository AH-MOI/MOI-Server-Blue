package com.dsm.moi.utils.handler;

import com.dsm.moi.utils.exception.AccountNotFoundException;
import com.dsm.moi.utils.exception.RuleViolationInformationException;
import com.dsm.moi.utils.exception.StudentNotFoundException;
import com.dsm.moi.utils.exception.TokenInvalidException;
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

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ApiErrorResponseForm> accountNotFoundExceptionHandler(AccountNotFoundException ex) {
        ApiErrorResponseForm response = new ApiErrorResponseForm("일치하는 계정을 찾을 수 없습니다.", "일치하는 계정을 찾을 수 없습니다.");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TokenInvalidException.class)
    public ResponseEntity<ApiErrorResponseForm> tokenInvalidExceptionHandler(TokenInvalidException ex) {
        ApiErrorResponseForm response = new ApiErrorResponseForm("토큰이 잘못되었습니다.", "토큰이 잘못되었습니다.");
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ApiErrorResponseForm> studentNotFoundExceptionHandler(StudentNotFoundException ex) {
        ApiErrorResponseForm response = new ApiErrorResponseForm("사용자를 찾을 수 없습니다.", "사용자를 찾을 수 없습니다.");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
