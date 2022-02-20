package com.example.hrms.business.concretes;

import com.example.hrms.business.Mesajlar;
import com.example.hrms.business.abstracts.JobSeekerService;
import com.example.hrms.core.aktivasyon.AktivasyonService;
import com.example.hrms.core.dataAccess.UserDao;
import com.example.hrms.core.utilities.BusinessRules;
import com.example.hrms.core.utilities.UserKontrolService;
import com.example.hrms.core.utilities.result.*;
import com.example.hrms.dataAccess.abstracts.JobSeekerDao;
import com.example.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {
    private JobSeekerDao jobSeekerDao;
    private UserDao userDao;
    private AktivasyonService aktivasyonService;
    private UserKontrolService userKontrolService;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, UserDao userDao, 
                            AktivasyonService aktivasyonService,
                            UserKontrolService userKontrolService) {
        super();
        this.jobSeekerDao = jobSeekerDao;
        this.userDao = userDao;
        this.aktivasyonService = aktivasyonService;
        this.userKontrolService = userKontrolService;
    }
    
    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll());
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        var result = BusinessRules.run(passwordYanlis(jobSeeker), mailVar(jobSeeker),
                jobSeekerIdentityNumberVar(jobSeeker), validateMernis(jobSeeker));
        if (result != null) {
            return result;
        } else if (aktivasyonService.sendMail(jobSeeker)) {
            this.jobSeekerDao.save(jobSeeker);
            return new SuccessResult(Mesajlar.jobSeekerEklendi);
        }

        return new ErrorResult(Mesajlar.jobSeekerError);
    }

    //şifre hatalı ise verilecek mesajı çağırır
    private Result passwordYanlis(JobSeeker jobSeeker) {
        if (!jobSeeker.getPassword().equals(jobSeeker.getPasswordRepeat())) {
            return new ErrorResult(Mesajlar.passwordYanlis);
        }
        return new SuccessResult();
    }

    //maile mecvutsa verilecek mesajı çağırır
    private Result mailVar(JobSeeker jobSeeker) {
        if (this.userDao.findUserByEmail(jobSeeker.getEmail()) != null) {
            return new ErrorResult(Mesajlar.mailVar);
        }

        return new SuccessResult();
    }

    //aynı tc de biri  varsa verilecek mesajı çağırır
    private Result jobSeekerIdentityNumberVar(JobSeeker jobSeeker) {
        if (this.jobSeekerDao.getByIdentityNumber(jobSeeker.getIdentityNumber()) != null) {
            return new ErrorResult(Mesajlar.jobSeekerIdentityNumberVar);
        }
        return new SuccessResult();
    }

    //mernisi kontrol ederek verilecek messajı çağırır
    private Result validateMernis(JobSeeker jobSeeker) {
        if (userKontrolService.validateByMernis(Long.parseLong(jobSeeker.getIdentityNumber()), jobSeeker.getFirstName(),
                jobSeeker.getLastName(), jobSeeker.getYearOfBirth())) {
            return new SuccessResult(Mesajlar.mernisSuccess);
        }
        return new ErrorResult(Mesajlar.mernisError);
    }

    @Override
    public Result delete(JobSeeker jobSeeker) {
        this.jobSeekerDao.delete(jobSeeker);
        return new SuccessResult(Mesajlar.jobSeekerSilindi);
    }

    @Override
    public DataResult<JobSeeker> getByIdentityNumber(String tc) {
        return jobSeekerDao.getByIdentityNumber(tc);
    }

    @Override
    public Result imageUpload(int seekerId, MultipartFile file) throws IOException {
        return null;
    }
}
//resim için fonksiyonlar yazılacak