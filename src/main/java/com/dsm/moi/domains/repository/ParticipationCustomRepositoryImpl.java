package com.dsm.moi.domains.repository;

import com.dsm.moi.domains.domain.Participation;
import com.dsm.moi.utils.exception.ProjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ParticipationCustomRepositoryImpl implements ParticipationCustomRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Participation> findByStudentId(String studentId) {
        return entityManager.createQuery("SELECT p FROM Participation p " +
                "WHERE p.student.id = :studentId")
                .setParameter("studentId", studentId)
                .getResultList();
    }

    @Override
    public List<Participation> findByProjectId(String projectId) {
        return entityManager.createQuery("SELECT p FROM Participation p " +
                "WHERE p.project.id = :projectId")
                .setParameter("projectId", projectId)
                .getResultList();
    }

    @Override
    public Optional<Participation> findByStudentIdAndProjectId(String studentId, String projectId) {
        return entityManager.createQuery("SELECT p FROM Participation p " +
                "WHERE p.student.id = :studentId " +
                "AND p.project.id = :projectId", Participation.class)
                .setParameter("studentId", studentId)
                .setParameter("projectId", projectId)
                .getResultList()
                .stream()
                .findAny();
    }
}