package com.swe.erecruitment.repository;

import com.swe.erecruitment.model.UserAvatar;
import com.swe.erecruitment.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAvatarJpaRepository extends JpaRepository<UserAvatar, Integer> {
    Users findById(int id);
}
