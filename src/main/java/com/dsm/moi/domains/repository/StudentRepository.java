package com.dsm.moi.domains.repository;

import com.dsm.moi.domains.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
