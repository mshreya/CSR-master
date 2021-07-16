package com.csr.config;

import com.csr.service.impl.UserDetailsServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@CrossOrigin("*")
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        final String requestTokenHeader=httpServletRequest.getHeader("Authorization");

    System.out.println(requestTokenHeader);
    String employeeId=null;
    String jwtToken=null;

    if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")){

        //yes
        jwtToken = requestTokenHeader.substring(7);
        try {

            employeeId = this.jwtUtils.extractUsername(jwtToken);
        }catch(ExpiredJwtException e){
            e.printStackTrace();
            System.out.println("jwt token expired");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error");
        }
    }else{
        System.out.println("Invalid token, not start with bearer");
    }

    //validated
        if(employeeId!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            final UserDetails userDetails=this.userDetailsServiceImpl.loadUserByUsername(employeeId);
            if(this.jwtUtils.validateToken(jwtToken,userDetails)){
                //token valid
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }}else {
                System.out.println("token not valid");
            }

        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "authorization, content-type, xsrf-token");
        httpServletResponse.addHeader("Access-Control-Expose-Headers", "xsrf-token");
        if ("OPTIONS".equals(httpServletRequest.getMethod())) {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }
    }
}
