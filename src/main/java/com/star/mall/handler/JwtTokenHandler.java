package com.star.mall.handler;

import com.star.mall.model.UserDetail;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenHandler {

    private final static Logger logger = LoggerFactory.getLogger(JwtTokenHandler.class);

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

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

    public boolean validateToken(String token){
        return !isTokenExpired(token);
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
//        Claims claims = null;
//        try {
//            claims = Jwts.parserBuilder()
//                    .setSigningKey(secret)
//                    .build()
//                    .parseClaimsJws(token)
//                    .getBody();
//        } catch (Exception e) {
//            logger.info("JWT格式验证失败:{}", token);
//        }
        return Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String generateAccessToken(UserDetails userDetails) {
        Date createDate = new Date();
        Date expireDate = new Date(createDate.getTime() + expiration * 1000);

        byte[] keyBytes = Decoders.BASE64.decode(secret);
        Key key = Keys.hmacShaKeyFor(keyBytes);

        return Jwts
                .builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(key)
                .compact();
    }
}
