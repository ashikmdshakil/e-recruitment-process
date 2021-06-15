package com.swe.erecruitment.model;

import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Component
@Entity
@Scope(value = "prototype")
public class Circular {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToOne
    private Users owner;
    @ManyToMany
    private List<Users> applicants;
    private Date startTime;
    private Date deadTime;
    private int seats;
    private String details;
    private String token;

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

    public Users getOwner() {
        return owner;
    }

    public void setOwner(Users owner) {
        this.owner = owner;
    }

    public List<Users> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Users> applicants) {
        this.applicants = applicants;
    }

    public Date getDeadTime() {
        return deadTime;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setDeadTime(Date deadTime) {
        this.deadTime = deadTime;
    }
}
