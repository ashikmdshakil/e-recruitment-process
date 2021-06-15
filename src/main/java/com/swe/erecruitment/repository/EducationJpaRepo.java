package com.swe.erecruitment.repository;

import com.swe.erecruitment.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationJpaRepo extends JpaRepository<Education, Integer> {
    List<Education> findByUserId(int id);
}
