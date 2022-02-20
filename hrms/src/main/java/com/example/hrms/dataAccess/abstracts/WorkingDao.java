package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Working;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingDao extends JpaRepository<Working, Integer> {

}
