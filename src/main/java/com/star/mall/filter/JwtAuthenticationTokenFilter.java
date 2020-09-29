package com.star.mall.filter;


import com.star.mall.handler.JwtTokenHandler;
import com.star.mall.model.UserDetail;
import io.jsonwebtoken.JwtHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    JwtTokenHandler jwtTokenHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authToken = request.getHeader("Authorization");
        String authTokenStart = "Bearer ";
        String username = null;

        if (!StringUtils.isEmpty(authToken) && authToken.startsWith(authTokenStart)){
            authToken = authToken.substring(authTokenStart.length());
            username = jwtTokenHandler.getUsernameByToken(authToken);
        }

        if (jwtTokenHandler.containToken(username,authToken) && !StringUtils.isEmpty(username) && SecurityContextHolder.getContext().getAuthentication()!=null){
            UserDetail userDetail = jwtTokenHandler.getUserByToken(authToken);
            if (jwtTokenHandler.validateToken(authToken)){
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail,null,userDetail.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        chain.doFilter(request, response);
    }
}
