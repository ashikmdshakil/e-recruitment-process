package com.swe.erecruitment.repository;

import com.swe.erecruitment.model.Certifications;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificationJpaRepo extends JpaRepository<Certifications, Integer> {
    List<Certifications> findByUserId(int id);
}
