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

        if(!student.equals(findStudent)) {
            findStudent.setId(student.getId());
            findStudent.setPassword(student.getPassword());
            findStudent.setName(student.getName());
            findStudent.setBirthday(student.getBirthday());
            findStudent.setSchool(student.getSchool());
            findStudent.setArea(student.getArea());
            findStudent.setGithub(student.getGithub());
            findStudent.setProfile(student.getProfile());
            findStudent.setHashtag(student.getHashtag());
            findStudent.setPhoneNumber(student.getPhoneNumber());
        }
    }
}
