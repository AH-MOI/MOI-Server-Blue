package com.dsm.moi.utils.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException() {
        super("사용자를 찾을 수 없습니다.");
    }
}
