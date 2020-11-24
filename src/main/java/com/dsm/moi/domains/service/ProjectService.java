package com.dsm.moi.domains.service;

import com.dsm.moi.domains.domain.Participation;
import com.dsm.moi.domains.repository.ParticipationRepository;
import com.dsm.moi.utils.form.ParticipatingProjectResponseForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProjectService {

    private ParticipationRepository participationRepository;

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
                    List<String> hashtag = Arrays.asList(p.getProject().getHashtag().split("#"));
                    LocalDate closingDate = p.getProject().getClosingDate();
                    String writer = p.getStudent().getName();

                    return new ParticipatingProjectResponseForm(title, content, hashtag, closingDate, writer);
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
                    List<String> hashtag = Arrays.asList(p.getProject().getHashtag().split("#"));
                    LocalDate closingDate = p.getProject().getClosingDate();
                    String writer = p.getStudent().getName();

                    return new ParticipatingProjectResponseForm(title, content, hashtag, closingDate, writer);
                })
                .collect(Collectors.toList());
    }
}
