package com.dsm.moi.domains.service;

import com.dsm.moi.domains.repository.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private ParticipationRepository participationRepository;

    @Autowired
    public ProjectService(ParticipationRepository participationRepository) {
        this.participationRepository = participationRepository;
    }

    public void getParticipatingProject(String studentId) {
        
    }
}
