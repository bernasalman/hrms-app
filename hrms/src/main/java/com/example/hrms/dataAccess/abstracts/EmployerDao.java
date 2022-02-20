package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.core.utilities.result.DataResult;
import com.example.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
    DataResult<Employer> getByEmail(String email);

    @Query("from Employer where user_id=:id")
    Employer getByUserId(int id);

    @Query("from Employer where user_id=:id and isActive=false")
    Employer getByUserIdIsActivateIsFalse(int id); //user id'ye göre getir aktif olmayanları

    List<Employer> getByUpdatedDataNotNull();


}