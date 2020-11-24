package com.dsm.moi.domains.repository;

import com.dsm.moi.domains.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, String> {
}