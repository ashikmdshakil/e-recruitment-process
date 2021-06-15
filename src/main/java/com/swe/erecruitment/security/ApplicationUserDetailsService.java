package com.swe.erecruitment.security;

import com.swe.erecruitment.model.Users;
import com.swe.erecruitment.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
    @Autowired
    private Users user;
    @Autowired
    private UserJpaRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        user = userRepo.findByEmail(email);
        return new ApplicationUserDetails(user);
    }
}
