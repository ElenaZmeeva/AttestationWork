package org.example.repository;

import org.example.entity.MedicalTests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalTestsRepository extends JpaRepository<MedicalTests, Long> {
}
