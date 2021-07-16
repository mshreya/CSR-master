package com.csr.controller;

import com.csr.model.Role;
import com.csr.model.User;
import com.csr.model.UserRole;
import com.csr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{employeeId}")
    public User getUser(@PathVariable("employeeId") String employeeId){
     return this.userService.getUser(employeeId);
    }

}
