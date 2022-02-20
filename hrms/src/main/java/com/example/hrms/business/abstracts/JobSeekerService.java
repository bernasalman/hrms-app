package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.result.DataResult;
import com.example.hrms.core.utilities.result.Result;
import com.example.hrms.entities.concretes.JobSeeker;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

//JobSeeker(iş arayanların) kullanacağı tarafın işinini yapar
public interface JobSeekerService {
    DataResult<List<JobSeeker>> getAll();
    Result add(JobSeeker jobSeeker);
    Result delete(JobSeeker jobSeeker);
    DataResult<JobSeeker> getByIdentityNumber(String tc);
    //DataResult<List<jobSeekerCvDto>> getDetails();

    //resim yüklemek için
    Result imageUpload(int seekerId, MultipartFile file) throws IOException;
}
