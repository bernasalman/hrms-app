package com.example.hrms.business.abstracts;

import com.example.hrms.core.entities.User;
import com.example.hrms.core.utilities.result.DataResult;

import java.util.List;

public interface UserService {
    DataResult<List<User>> getAll();
}
