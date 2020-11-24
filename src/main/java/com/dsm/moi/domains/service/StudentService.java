package com.dsm.moi.domains.service;

import com.dsm.moi.domains.domain.Student;
import com.dsm.moi.domains.repository.StudentRepository;
import com.dsm.moi.utils.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void updateStudentInformation(Student student) {
        Student findStudent = studentRepository.findById(student.getId())
                .orElseThrow(AccountNotFoundException::new);

        findStudent.setPhoneNumber(student.getPhoneNumber());
        findStudent.setArea(student.getArea());
        findStudent.setGithub(student.getGithub());
        findStudent.setHashtag(student.getHashtag());
        findStudent.setProfile(student.getProfile());
    }

    public Student getStudentById(String studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(AccountNotFoundException::new);
    }
}
