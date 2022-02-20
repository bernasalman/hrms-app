package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.UserService;
import com.example.hrms.core.dataAccess.UserDao;
import com.example.hrms.core.entities.User;
import com.example.hrms.core.utilities.result.DataResult;
import com.example.hrms.core.utilities.result.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {
    UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao){
        super();
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll());
    }
}
