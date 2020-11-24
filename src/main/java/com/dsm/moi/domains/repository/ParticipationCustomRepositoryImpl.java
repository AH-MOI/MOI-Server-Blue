package com.dsm.moi.domains.repository;

import com.dsm.moi.domains.domain.Participation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

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
}