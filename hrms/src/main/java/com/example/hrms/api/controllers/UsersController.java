package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.UserService;
import com.example.hrms.core.entities.User;
import com.example.hrms.core.utilities.result.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {


    private UserService usersService;

    @Autowired
    public UsersController(UserService usersService) {
        super();
        this.usersService = usersService;
    }

    @GetMapping("/getAll")
    public DataResult<List<User>> getAll() {
        return this.usersService.getAll();
    }
}
