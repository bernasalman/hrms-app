package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.SystemUserService;
import com.example.hrms.core.dataAccess.UserDao;
import com.example.hrms.core.utilities.result.DataResult;
import com.example.hrms.core.utilities.result.Result;
import com.example.hrms.core.utilities.result.SuccessDataResult;
import com.example.hrms.core.utilities.result.SuccessResult;
import com.example.hrms.dataAccess.abstracts.SystemUserDao;
import com.example.hrms.entities.concretes.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SystemUserManager implements SystemUserService {

    UserDao userDao;

    SystemUserDao systemUserDao;

    @Autowired
    public SystemUserManager(SystemUserDao systemUserDao, UserDao userDao) {
        super();
        this.systemUserDao = systemUserDao;
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<SystemUser>> getAll() {
        return new SuccessDataResult<List<SystemUser>>
                (this.systemUserDao.findAll(), "Sistem Kullanıcıları listelendi");
    }

    @Override
    public Result addSystemUser(SystemUser systemUser) {
        this.systemUserDao.save(systemUser); //ekleme ve güncelleme işlemlerini yapabilmek için
        return new SuccessResult("Sistem Kullanıcısı eklendi");
    }


}
