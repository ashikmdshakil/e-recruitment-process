package com.swe.erecruitment.repository;

import com.swe.erecruitment.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserJpaRepository extends JpaRepository<Users, Integer> {
    Users findById(int id);
    Users findByMobileNumber(String number);
    Users findByEmail(String email);
}
