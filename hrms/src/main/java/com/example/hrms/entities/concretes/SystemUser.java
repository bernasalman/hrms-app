package com.example.hrms.entities.concretes;

import com.example.hrms.core.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "systemUsers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "user_id")
public class SystemUser extends User {

    @JsonIgnore
    @Column(name = "systemUser_id")
    //@Id
    private int systemUserId;

    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private String lastName;


}
