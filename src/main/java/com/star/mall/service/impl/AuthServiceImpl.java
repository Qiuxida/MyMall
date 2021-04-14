package com.star.mall.service.impl;

import com.star.mall.handler.JwtTokenHandler;
import com.star.mall.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    AuthenticationManager authenticationManager;
    @Resource
    JwtTokenHandler jwtTokenHandler;

    @Override
    public String login(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return jwtTokenHandler.generateAccessToken(userDetails);
    }


}
