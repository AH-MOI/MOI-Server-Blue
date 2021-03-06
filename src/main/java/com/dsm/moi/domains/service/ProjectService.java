package com.dsm.moi.domains.service;

import com.dsm.moi.domains.domain.Participation;
import com.dsm.moi.domains.domain.Project;
import com.dsm.moi.domains.domain.Student;
import com.dsm.moi.domains.repository.ParticipationRepository;
import com.dsm.moi.utils.exception.ProjectNotFoundException;
import com.dsm.moi.utils.form.MyProjectDetailForm;
import com.dsm.moi.utils.form.ParticipatingProjectDetailForm;
import com.dsm.moi.utils.form.ParticipatingProjectResponseForm;
import com.dsm.moi.utils.form.StudentInformationResponseForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private final ParticipationRepository participationRepository;

    @Autowired
    public ProjectService(ParticipationRepository participationRepository) {
        this.participationRepository = participationRepository;
    }

    public List<ParticipatingProjectResponseForm> getMyProject(String studentId) {
        List<Participation> participationList = participationRepository.findByStudentId(studentId);
        return participationList.stream()
                .filter(p -> p.getProject().getWriter().getId().equals(studentId))
                .map(p -> {
                    String title = p.getProject().getTitle();
                    String content = p.getProject().getContent();
                    List<String> hashtag = Arrays.asList(p.getProject().getHashtag().substring(1).split("#"));
                    LocalDate closingDate = p.getProject().getClosingDate();
                    String writer = p.getStudent().getName();
                    int id = p.getProject().getId();

                    return new ParticipatingProjectResponseForm(id, title, content, hashtag, closingDate, writer);
                })
                .collect(Collectors.toList());
    }

    public List<ParticipatingProjectResponseForm> getParticipatingProject(String studentId) {
        List<Participation> participationList = participationRepository.findByStudentId(studentId);
        return participationList.stream()
                .filter(p -> !(p.getProject().getWriter().getId().equals(studentId)))
                .map(p -> {
                    String title = p.getProject().getTitle();
                    String content = p.getProject().getContent();
                    List<String> hashtag = Arrays.asList(p.getProject().getHashtag().substring(1).split("#"));
                    LocalDate closingDate = p.getProject().getClosingDate();
                    String writer = p.getProject().getWriter().getName();
                    int id = p.getProject().getId();

                    return new ParticipatingProjectResponseForm(id, title, content, hashtag, closingDate, writer);
                })
                .collect(Collectors.toList());
    }

    public ParticipatingProjectDetailForm getParticipatingProjectDetail(String studentId, String projectId) {
        Participation participation = participationRepository.findByStudentIdAndProjectId(studentId, projectId)
                .orElseThrow(ProjectNotFoundException::new);
        Project project = participation.getProject();

        ParticipatingProjectDetailForm form = new ParticipatingProjectDetailForm();
        form.setTitle(project.getTitle());
        form.setContent(project.getContent());
        form.setWriter(project.getWriter().getName());
        form.setHashtag(Arrays.asList(project.getHashtag().substring(1).split("#")));

        List<String> area = new ArrayList<>();
        List<String> personnel = new ArrayList<>();
        String totalPersonnel = project.getPersonnel();

        char[] chars = totalPersonnel.toCharArray();
        boolean isNumber = false;
        int startIndex = 0;
        for(int i = 0 ; i < chars.length ; i++) {
            if(!isNumber && '0' <= chars[i] && chars[i] <= '9') {
                area.add(totalPersonnel.substring(startIndex, i));
                isNumber = true;
                startIndex = i;
            } else if(isNumber && !('0' <= chars[i] && chars[i] <= '9')) {
                personnel.add(totalPersonnel.substring(startIndex, i));
                isNumber = false;
                startIndex = i + 1;
            }
        }
        personnel.add(totalPersonnel.substring(startIndex));

        List<Participation> projectList = participationRepository.findByProjectId(projectId);

        AtomicInteger index = new AtomicInteger(0);
        area.stream()
                .forEach(a -> {
                    int count = (int) projectList.stream()
                            .filter(p -> p.isPassed() && p.getArea().equals(a))
                            .count();
                    personnel.set(index.get(), count + "/" + personnel.get(index.get()));
                    index.set(index.get() + 1);
                });
        form.setAreas(area);
        form.setPersonnel(personnel);
        return form;
    }

    public MyProjectDetailForm getMyProjectDetail(String studentId, String projectId) {
        Participation participation = participationRepository.findByStudentIdAndProjectId(studentId, projectId)
                .orElseThrow(ProjectNotFoundException::new);
        Project project = participation.getProject();

        MyProjectDetailForm form = new MyProjectDetailForm();
        form.setTitle(project.getTitle());
        form.setContent(project.getContent());
        form.setWriter(project.getWriter().getName());
        form.setHashtag(Arrays.asList(project.getHashtag().substring(1).split("#")));

        List<String> area = new ArrayList<>();
        List<String> personnel = new ArrayList<>();
        String totalPersonnel = project.getPersonnel();

        char[] chars = totalPersonnel.toCharArray();
        boolean isNumber = false;
        int startIndex = 0;
        for(int i = 0 ; i < chars.length ; i++) {
            if(!isNumber && '0' <= chars[i] && chars[i] <= '9') {
                area.add(totalPersonnel.substring(startIndex, i));
                isNumber = true;
                startIndex = i;
            } else if(isNumber && !('0' <= chars[i] && chars[i] <= '9')) {
                personnel.add(totalPersonnel.substring(startIndex, i));
                isNumber = false;
                startIndex = i + 1;
            }
        }
        personnel.add(totalPersonnel.substring(startIndex));

        List<Participation> projectList = participationRepository.findByProjectId(projectId);
        AtomicInteger index = new AtomicInteger(0);
        area.stream()
                .forEach(a -> {
                    int count = (int) projectList.stream()
                            .filter(p -> p.isPassed() && p.getArea().equals(a))
                            .count();
                    personnel.set(index.get(), count + "/" + personnel.get(index.get()));
                    index.set(index.get() + 1);
                });
        form.setAreas(area);
        form.setPersonnel(personnel);

        List<Participation> participationList = participationRepository.findByProjectId(projectId);
        List<StudentInformationResponseForm> students = participationList.stream()
                .filter(p -> !(p.isPassed()))
                .map(p -> {
                    Student student = p.getStudent();
                    return new StudentInformationResponseForm(student.getId(), student.getName(), student.getBirthday(),
                            student.getSchool(), student.getProfile(), student.getGithub(), student.getPhoneNumber(),
                            student.getArea(), student.getHashtag(), student.getStar(), student.getIntroduce());
                })
                .collect(Collectors.toList());
        form.setAppliedStudent(students);

        return form;
    }
}
