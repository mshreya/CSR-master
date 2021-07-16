package com.csr.service.impl;

import com.csr.model.User;
import com.csr.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user=this.userRepository.findByEmployeeId(s);
        if(user==null){
            System.out.println("EmployeeId not found");
            throw new UsernameNotFoundException("No user found");
        }
        return user;
    }
}
