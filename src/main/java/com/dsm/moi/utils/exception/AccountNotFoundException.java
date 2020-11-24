package com.dsm.moi.utils.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException() {
        super("일치하는 계정을 찾을 수 없습니다.");
    }
}