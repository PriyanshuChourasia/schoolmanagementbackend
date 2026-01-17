package com.wishalpha.schoolmanagement.auth.utils;


import com.wishalpha.schoolmanagement.common.exceptionHandler.exceptions.JwtException;
import com.wishalpha.schoolmanagement.common.exceptionHandler.exceptions.JwtMalformedException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${app.jwtExpirationMs}")
    private String jwtExpirationMs;

    public String getJwtFromHeader(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        logger.debug("Token: {}",bearerToken);
//        This step removing bearer from token
        if(bearerToken != null && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);
        }
        return null;
    }

    public String generateAccessTokenFromUsername(UserDetails userDetails){
        String username = userDetails.getUsername();
        return Jwts.builder()
                .subject(username)
                .issuer(applicationName)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+ 4L * 24 * 60 * 60 * 1000))
                .signWith(key())
                .compact();
    }

    public String generateRefreshTokenFromUsername(UserDetails userDetails){
        String username = userDetails.getUsername();
        return Jwts.builder()
                .subject(username)
                .issuer(applicationName)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+ 7L * 24 * 60 * 60 * 1000))
                .signWith(key())
                .compact();
    }

    public boolean validateJwtToken(String token){
        try{
            Jwts.parser().verifyWith((SecretKey) key()).build().parseSignedClaims(token);
            return  true;
        }catch (MalformedJwtException me){
            throw new JwtMalformedException("Token is Malfunctioned");
        }catch (ExpiredJwtException ex){
            throw new JwtException("Token is Expired");
        }catch (UnsupportedJwtException ex){
            throw new JwtException("Token is not supported for this request");
        }catch (IllegalArgumentException ex){
            throw new JwtException("Illegal Token argument");
        }
    }

    public String getUserNameFromToken(String token){
        return Jwts.parser().verifyWith((SecretKey) key()).build().parseSignedClaims(token).getPayload().getSubject();
    }



    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }
}
