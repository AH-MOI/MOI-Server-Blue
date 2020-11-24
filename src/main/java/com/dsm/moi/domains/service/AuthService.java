package com.dsm.moi.domains.service;

import com.dsm.moi.domains.domain.Student;
import com.dsm.moi.domains.repository.StudentRepository;
import com.dsm.moi.utils.exception.RuleViolationInformationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.time.LocalDate;

@Service
public class AuthService {

    private static final Integer NON_CHECK = -1;

    private static final String ALGORITHM = "SHA-512";
    private static final String ENCODING = "UTF-8";

    private static final Logger log = LoggerFactory.getLogger(AuthService.class);

    private final StudentRepository studentRepository;

    @Autowired
    public AuthService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public boolean isAlreadyExistStudent(String studentId) {
        try {
            studentRepository.findById(studentId)
                    .orElseThrow(Exception::new);
            return false;
        } catch(Exception e) {
            return true;
        }
    }

    public void join(Student student) {
        String userId = student.getId();
        String password = student.getPassword();
        String name = student.getName();
        LocalDate birthday = student.getBirthday();
        String school = student.getSchool();

        LocalDate now = LocalDate.now();

        patternCheck(userId, 4, 24, "^[a-zA-Z0-9|@|.]*$");
        patternCheck(password, 4, 24, "^[a-zA-Z0-9|*|!|@|^]*$");
        patternCheck(name, 1, 12, "^[a-zA-Zㄱ-ㅎ가-힣]*$");
        patternCheck(birthday.toString(), NON_CHECK, NON_CHECK, "^[0-9]{4}-[0-9]{2}-[0-9]{2}$");
        patternCheck(school, 2, 2, "^(대덕|광주|대구)$");

        if(birthday.isAfter(now)) {
            throw new RuleViolationInformationException();
        }

        student.setPassword(encodingPassword(student.getPassword()));
        studentRepository.save(student);
    }

    private void patternCheck(String target, int minimumLength, int maximumLength, String pattern) {
        boolean isNormal;
        if(minimumLength == -1 && maximumLength == -1) {
            isNormal = target.matches(pattern);
        } else {
            isNormal = target.length() >= minimumLength && target.length() <= maximumLength && target.matches(pattern);
        }
        if (!isNormal)
            throw new RuleViolationInformationException();
    }

    public boolean samePassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    public String encodingPassword(String original) {
        String resultHex = null;
        try {
            MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
            digest.reset();
            digest.update(original.getBytes(ENCODING));
            resultHex = String.format("%0128x", new BigInteger(1, digest.digest()));
        } catch(Exception e) {
            log.error("현재 인코딩 방식 또는 해시 알고리즘이 잘못 되었습니다.");
            e.printStackTrace();
        }
        return resultHex;
    }
}