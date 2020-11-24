package com.dsm.moi.utils.exception;

public class NonExistAccountException extends RuntimeException {
    public NonExistAccountException() {
        super("일치하는 계정을 찾을 수 없습니다.");
    }
}
