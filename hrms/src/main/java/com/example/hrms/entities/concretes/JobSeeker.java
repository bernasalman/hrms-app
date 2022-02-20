package com.example.hrms.entities.concretes;

import com.example.hrms.core.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "jobSeekers")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "user_id")
public class JobSeeker extends User {

    @Column(name = "user_id")
    @JsonIgnore
    private int jobSeekerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @Column(name = "identity_number")
    private String identityNumber;

    private String passwordRepeat;

    @Column(name = "is_verified_by_email")
    @JsonIgnore
    private boolean verifiyEmail = false;

    @Column(name = "created_date")
    @JsonIgnore
    private LocalDate createDate;

    @Column(name = "is_deleted")
    @JsonIgnore
    private boolean is_deleted;

    @Column(name = "image_url")
    private String imageUrl;

    public JobSeeker() {
        this.createDate = LocalDate.now();
    }

    @OneToOne(mappedBy = "candidate")
    private Cv cv;


}

