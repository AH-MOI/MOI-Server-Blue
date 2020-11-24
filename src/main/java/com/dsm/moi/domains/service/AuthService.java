package com.dsm.moi.domains.service;

import com.dsm.moi.domains.domain.Student;
import com.dsm.moi.utils.exception.RuleViolationInformationException;

import java.time.LocalDate;

public class AuthService {

    private static final Integer NON_CHECK = -1;

    public void join(Student student) {
        String userId = student.getId();
        String password = student.getPassword();
        String name = student.getName();
        LocalDate birthday = student.getBirthday();
        String school = student.getSchool();

        LocalDate now = LocalDate.now();

        patternCheck(userId, 4, 16, "^[a-zA-Z]*$");
        patternCheck(password, 4, 16, "^[a-zA-Z0-9|*|!|@|^]*$");
        patternCheck(name, 1, 12, "^[a-zA-Z]*$");
        patternCheck(birthday.toString(), NON_CHECK, NON_CHECK, "^[0-9]{4}-[0-9]{2}-[0-9]{2}$");
        patternCheck(school, 2, 2, "^(대덕|광주|대구)$");

        if(birthday.isAfter(now))
            throw new RuleViolationInformationException();
    }

    private void patternCheck(String target, int minimumLength, int maximumLength, String pattern) {
        boolean isNormal;
        if(minimumLength == -1 && maximumLength == -1) {
            isNormal = target.matches(pattern);
        } else {
            isNormal = target.length() >= minimumLength && target.length() <= maximumLength && target.matches(pattern);
        }
        if (!isNormal) {
            throw new RuleViolationInformationException();
        }
    }
}