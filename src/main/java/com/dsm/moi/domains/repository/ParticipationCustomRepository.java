package com.dsm.moi.domains.repository;

import com.dsm.moi.domains.domain.Participation;

import java.util.List;
import java.util.Optional;

public interface ParticipationCustomRepository {
    List<Participation> findByStudentId(String studentId);
    List<Participation> findByProjectId(String projectId);
    Optional<Participation> findByStudentIdAndProjectId(String studentId, String projectId);
}
