package com.csr.service;

import com.csr.model.User;
import com.csr.model.UserRole;

import java.util.Set;

public interface UserService {

    //create user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by employeeId
    public User getUser(String employeeId);


}
