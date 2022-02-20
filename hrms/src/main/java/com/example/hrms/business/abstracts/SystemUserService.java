package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.result.DataResult;
import com.example.hrms.core.utilities.result.Result;
import com.example.hrms.entities.concretes.SystemUser;

import java.util.List;

public interface SystemUserService {

        DataResult<List<SystemUser>> getAll();

        Result addSystemUser(SystemUser systemUser);
    }

