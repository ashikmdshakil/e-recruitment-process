package com.swe.erecruitment.model;

import org.apache.catalina.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Scope(value = "prototype")
public class Evalution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Users applicant;
    @OneToOne
    private Circular circular;
    private float marks;
    private String comment;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getApplicant() {
        return applicant;
    }

    public void setApplicant(Users applicant) {
        this.applicant = applicant;
    }

    public Circular getCircular() {
        return circular;
    }

    public void setCircular(Circular circular) {
        this.circular = circular;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
