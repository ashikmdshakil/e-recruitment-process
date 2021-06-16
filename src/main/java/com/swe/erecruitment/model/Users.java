package com.swe.erecruitment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity
@Scope(scopeName = "prototype")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String mobileNumber;
    private String address;
    private boolean isArchived = false;
    @OneToOne
    private UserAvatar userAvatar;
    @ManyToOne
    private Roles role;
    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Education> educations;
    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Experience> experiences;
    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Certifications> certifications;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public UserAvatar getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(UserAvatar userAvatar) {
        this.userAvatar = userAvatar;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public List<Certifications> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<Certifications> certifications) {
        this.certifications = certifications;
    }

}
