package com.swe.erecruitment.repository;

import com.swe.erecruitment.model.Evalution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvalutionJpaRepo extends JpaRepository<Evalution, Integer> {
    Evalution findByApplicantIdAndCircularId(int aId, int cId);
    List<Evalution> findByCircularIdOrderByMarks(int cId);
}
