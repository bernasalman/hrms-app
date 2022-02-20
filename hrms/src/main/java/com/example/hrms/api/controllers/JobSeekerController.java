package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.JobSeekerService;
import com.example.hrms.core.utilities.result.DataResult;
import com.example.hrms.core.utilities.result.Result;
import com.example.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/jobSeeker")
@CrossOrigin
public class JobSeekerController {
    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerController(JobSeekerService jobSeekerService) {
        super();
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobSeeker>> getAll(){
        return this.jobSeekerService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid JobSeeker jobSeeker) {
        Result result = this.jobSeekerService.add(jobSeeker);
        if(result.isSuccess())
        {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);

    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody @Valid JobSeeker jobSeeker) {
        Result result = this.jobSeekerService.delete(jobSeeker);
        if(result.isSuccess())
        {
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.badRequest().body(result);
    }



   /* @GetMapping("/getalldetails")
    public DataResult<List<candidateCvDto>> getDetails(){
    return this.candidateService.getDetails();
    }
    */

    @PostMapping("/image")
    public ResponseEntity<?>  imageUpload(@RequestParam("jobSeekerId") int jobSeekerId,@RequestParam("file") MultipartFile file) throws IOException {
        DataResult result = null ;
        try {
            result = (DataResult) this.jobSeekerService.imageUpload(jobSeekerId,file);
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(result);
    }
    }


