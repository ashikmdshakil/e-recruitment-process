package com.swe.erecruitment.repository;

import com.swe.erecruitment.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceJpaRepo extends JpaRepository<Experience, Integer> {
    List<Experience> findByUserId(int id);
}
