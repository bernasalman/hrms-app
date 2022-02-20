package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.core.utilities.result.DataResult;
import com.example.hrms.core.utilities.result.Result;
import com.example.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employer")
@CrossOrigin
public class EmployerController {
    private EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }


    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll() {
        return employerService.getAll();
    }


    @PostMapping("/add")
    public Result add(@RequestBody Employer employer) {
        return employerService.add(employer);
    }

    @PostMapping("/confirmemployer")
    public Result confirmEmployer(@RequestParam int id) {
        return employerService.confirmEmployer(id);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Employer employer) {
        return employerService.update(employer);
    }

    @PostMapping("/updateconfirm")
    public Result updateConfirm(@RequestParam int id) {
        return employerService.updateConfirm(id);
    }

    @GetMapping("/getbyuserid")
    public DataResult<Employer> getByUserId(@RequestParam int id) {
        return employerService.getByUserId(id);
    }

    @GetMapping("/getByUpdatedDataNotNull")
    DataResult<List<Employer>> getByUpdatedDataNotNull(){
        return employerService.getByUpdatedDataNotNull();
    }

}

