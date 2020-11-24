package com.dsm.moi.utils.exception;

public class RuleViolationInformationException extends RuntimeException {
    public RuleViolationInformationException() {
        super("회원의 정보가 잘못되었습니다.");
    }
}
