package com.swe.erecruitment.repository;

import com.swe.erecruitment.model.Circular;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CircularJpaRepository extends JpaRepository<Circular, Integer> {
    List<Circular> findByOwnerIdOrderByDeadTimeAsc(int id);
    Circular findByToken(String token);
    Circular findById(int id);
}
