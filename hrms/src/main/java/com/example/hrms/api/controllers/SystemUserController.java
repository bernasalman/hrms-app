package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.SystemUserService;
import com.example.hrms.core.utilities.result.DataResult;
import com.example.hrms.core.utilities.result.Result;
import com.example.hrms.entities.concretes.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/systemUser")
public class SystemUserController {

    SystemUserService systemUserService;

    @Autowired
    public SystemUserController(SystemUserService systemUserService) {
        this.systemUserService = systemUserService;
    }

    @GetMapping("/getAll")
    public DataResult<List<SystemUser>> getAll() {
        return systemUserService.getAll();
    }


    @PostMapping(value = "/add")
    public Result addSystemEmployee(@RequestBody SystemUser systemUser) {
        return systemUserService.addSystemUser(systemUser);

    }
}
