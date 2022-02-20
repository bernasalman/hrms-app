package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SystemUserDao extends JpaRepository<SystemUser, Integer> {
   SystemUser getById(int id);

   List<SystemUser> findById(int id);
}
