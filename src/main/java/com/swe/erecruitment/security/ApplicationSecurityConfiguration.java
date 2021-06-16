package com.swe.erecruitment.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO Auto-generated method stub
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        http
                .cors().and()
                .authorizeRequests()
                .antMatchers("/admin**").hasAuthority("admin")
                .antMatchers("/createCircular").hasAuthority("admin")
                .antMatchers("/adminGetsCirculars").hasAuthority("admin")
                .antMatchers("/saveEvalution").hasAuthority("admin")
                .antMatchers("/getEvalution").hasAuthority("admin")
                .antMatchers("/getSortedEvalution").hasAuthority("admin")
                .antMatchers("/addExperience").hasAuthority("user")
                .antMatchers("/addEducation").hasAuthority("user")
                .antMatchers("/addCertification").hasAuthority("user")
                .antMatchers("/updateCV").hasAuthority("user")
                .antMatchers("/applyJob").hasAuthority("user")
                .antMatchers("/signIn").hasAnyAuthority("user","admin")
                .antMatchers("/getUserByEmail").hasAnyAuthority("user","admin")
                .antMatchers("/getUserById").hasAnyAuthority("user","admin")
                .antMatchers("/getCircular").hasAnyAuthority("user","admin")
                .antMatchers("/getCircularById").hasAnyAuthority("user","admin")
                .antMatchers("/getExperiences").hasAnyAuthority("user","admin")
                .antMatchers("/getEducations").hasAnyAuthority("user","admin")
                .antMatchers("/getCertifications").hasAnyAuthority("user","admin")
                .antMatchers("/signupAdmin").permitAll()
                .antMatchers("/signupUser").permitAll()
                .antMatchers("/").permitAll()
                //.anyRequest().authenticated()
                .and().httpBasic()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and().csrf().disable();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("GET","POST")
                        .allowedOrigins("*");
            }
        };
    }
}
