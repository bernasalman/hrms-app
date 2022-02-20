package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.result.DataResult;
import com.example.hrms.core.utilities.result.Result;
import com.example.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll();

    Result add(Employer employer);

    DataResult<Employer> getByEmail(String email);

    Result confirmEmployer(int id);

    Result update(Employer employer);

    Result updateConfirm(int userId);

    DataResult<Employer> getByUserId(int id);

    DataResult<List<Employer>> getByUpdatedDataNotNull();
}
