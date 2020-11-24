package com.dsm.moi.domains.repository;

import com.dsm.moi.domains.domain.Participation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationRepository extends JpaRepository<Participation, Integer>, ParticipationCustomRepository {
}