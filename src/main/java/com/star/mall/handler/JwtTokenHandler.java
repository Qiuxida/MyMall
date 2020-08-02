package com.star.mall.handler;

import com.star.mall.model.UserDetail;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class JwtTokenHandler {

    @Value("${jwt.secret}")
    private String secret;

    private Map<String,String> tokenMap = new ConcurrentHashMap();

    public UserDetail getUserByToken(String token){
        UserDetail userDetail = new UserDetail();
        Claims claims = getClaimsFromToken(token);
        String username = claims.getSubject();
        userDetail.setUsername(username);
        return userDetail;
    }

    public String getUsernameByToken(String token){
        Claims claims = getClaimsFromToken(token);
        return claims.getSubject();
    }

    public boolean containToken(String username, String token){
        return (username!=null && tokenMap.containsKey(username) && tokenMap.get(username).equals(token));
    }

    public boolean validateToken(String token){
        return isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        Date expiration = getExpirationByToken(token);
        return expiration.before(new Date());
    }

    public Date getExpirationByToken(String token){
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    private Claims getClaimsFromToken(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public String generateAccessToken(UserDetails userDetails) {
        return "";
    }
}
