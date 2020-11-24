package com.dsm.moi.domains.service;

import com.dsm.moi.domains.domain.Participation;
import com.dsm.moi.domains.domain.Student;
import com.dsm.moi.domains.repository.ParticipationRepository;
import com.dsm.moi.domains.repository.StudentRepository;
import com.dsm.moi.utils.exception.AccountNotFoundException;
import com.dsm.moi.utils.exception.ProjectNotFoundException;
import com.dsm.moi.utils.exception.StudentNotFoundException;
import com.dsm.moi.utils.form.StudentInformationResponseForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private ParticipationRepository participationRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, ParticipationRepository participationRepository) {
        this.studentRepository = studentRepository;
        this.participationRepository = participationRepository;
    }

    public List<StudentInformationResponseForm> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(s -> new StudentInformationResponseForm(
                        s.getId(),
                        s.getName(),
                        s.getBirthday(),
                        s.getSchool(),
                        s.getProfile(),
                        s.getGithub(),
                        s.getPhoneNumber(),
                        s.getArea(),
                        s.getHashtag(),
                        s.getStar()
                ))
                .collect(Collectors.toList());
    }

    public void acceptProject(String appliedStudentId, String projectId) {
        List<Participation> projectList = participationRepository.findByProjectId(projectId);
        Participation participation = projectList.stream()
                .filter(p -> !p.isPassed())
                .filter(p -> p.getStudent().getId().equals(appliedStudentId))
                .findAny()
                .orElseThrow(StudentNotFoundException::new);
        participation.setPassed(true);
    }

    public void updateStudentInformation(Student student) {
        Student findStudent = studentRepository.findById(student.getId())
                .orElseThrow(AccountNotFoundException::new);

        findStudent.setPhoneNumber(student.getPhoneNumber());
        findStudent.setArea(student.getArea());
        findStudent.setGithub(student.getGithub());
        findStudent.setHashtag(student.getHashtag());
        findStudent.setProfile(student.getProfile());
        studentRepository.save(findStudent);
    }

    public Student getStudentById(String studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(AccountNotFoundException::new);
    }
}
