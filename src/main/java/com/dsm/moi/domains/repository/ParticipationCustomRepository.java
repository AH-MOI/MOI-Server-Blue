package com.dsm.moi.domains.repository;

import com.dsm.moi.domains.domain.Participation;

import java.util.List;

public interface ParticipationCustomRepository {
    List<Participation> findByStudentId(String studentId);
}
