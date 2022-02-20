package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.core.utilities.result.*;
import com.example.hrms.dataAccess.abstracts.EmployerDao;
import com.example.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployerManager implements EmployerService {
    EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(employerDao.findAll());
    }

    @Override
    public Result add(Employer employer) {
        if (!employer.getPassword().equals(employer.getPasswordRepeat())) {
            return new ErrorResult("doğrulama hatası");
        }
        if (getByEmail(employer.getEmail()) != null) {
            return new ErrorResult("zaten sistemde kayıtlısınız");
        }
        employerDao.save(employer);
        return new SuccessResult("ekleme başarılı");
    }

    @Override
    public DataResult<Employer> getByEmail(String email) {
        return this.employerDao.getByEmail(email);
    }

    @Override
    public Result confirmEmployer(int id) {
        Employer employer = employerDao.getByUserId(id);
        employer.setConfirm(true);
        employerDao.save(employer);
        return new SuccessResult("onaylama başarılı");
    }

    @Override
    public Result update(Employer employer) {
        Employer updatedUser = employerDao.getByUserId(employer.getUser_id());
        updatedUser.setUpdatedData(employer);
        employerDao.save(updatedUser);
        return new SuccessResult("Güncelleme başarılı (aktivasyon için onay bekleniyor)");
    }

    @Override
    public Result updateConfirm(int userId) {
        Employer employer = employerDao.getByUserId(userId);
        if (!Objects.isNull(employer.getUpdatedData())) {
            Employer updatedData = employer.getUpdatedData();
            //Saves updated data instead of main data and deletes updated data row.
            employerDao.save(updatedData);
            return new SuccessResult("kullanıcı onay durumu Onaylandı olarak değiştirildi");
        }
        employer.setIsActive(!employer.getIsActive());
        employerDao.save(employer);
        return new SuccessResult("kullanıcı onay durumu Onaylandı olarak değiştirildi");
    }

    @Override
    public DataResult<Employer> getByUserId(int id) {
        return new SuccessDataResult<Employer>(employerDao.getByUserId(id));
    }

    @Override
    public DataResult<List<Employer>> getByUpdatedDataNotNull() {
        return new SuccessDataResult<List<Employer>>(employerDao.getByUpdatedDataNotNull());
    }
}
