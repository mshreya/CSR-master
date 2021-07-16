package com.csr.service.impl;

import com.csr.model.User;
import com.csr.model.UserRole;
import com.csr.repo.RoleRepository;
import com.csr.repo.UserRepository;
import com.csr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

   //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local;
        local = this.userRepository.findByEmployeeId(user.getEmployeeId());
        if(local!=null){
            System.out.println("User already present");
          //  throw new Exception("User already present");
        }else {
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
     return local;
    }

    //getting user by employeeId
    @Override
    public User getUser(String employeeId) {
        return this.userRepository.findByEmployeeId(employeeId);
    }

}
