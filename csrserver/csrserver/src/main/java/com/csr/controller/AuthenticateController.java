package com.csr.controller;

import com.csr.config.JwtUtils;
import com.csr.model.JwtRequest;
import com.csr.model.JwtResponse;
import com.csr.model.User;
import com.csr.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private JwtUtils jwtUtils;

//generate token
    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
    try {
        authenticate(jwtRequest.getEmployeeId(),jwtRequest.getPassword());

    }catch (UsernameNotFoundException e){
        throw new Exception("User not found");
    }

    //authenticate
        UserDetails userDetails=this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getEmployeeId());
     String token=this.jwtUtils.generateToken(userDetails);
     return ResponseEntity.ok(new JwtResponse(token));
    }


    private void authenticate(String employeeId, String password) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(employeeId,password));

        }catch (DisabledException e){
            throw new Exception("User Disabled");
        }catch (BadCredentialsException e){
            throw new Exception("Invalid credentials");
        }

    }

    //returns the details of current user 
    @GetMapping("/current-user")
    public User currentUser(Principal principal){
     return ((User) this.userDetailsServiceImpl.loadUserByUsername(principal.getName()));
    }
}
