package com.wishalpha.schoolmanagement.auth.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.wishalpha.schoolmanagement.auth.service.impl.CustomUserDetailService;
import com.wishalpha.schoolmanagement.auth.utils.JwtUtils;
import com.wishalpha.schoolmanagement.common.exceptionHandler.exceptions.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class AuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Override
    protected void doFilterInternal( HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
            String token = jwtUtils.getJwtFromHeader(request);
            try{
                if(token != null && jwtUtils.validateJwtToken(token)){
                    String username = jwtUtils.getUserNameFromToken(token);
                    UserDetails userDetails = customUserDetailService.loadUserByUsername(username);
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
                filterChain.doFilter(request,response);
            }catch (JwtException ex){
                SecurityContextHolder.clearContext();
                Map<String,Object> res = new HashMap<String,Object>();
                Map<String,Object> error = new HashMap<String,Object>();
                Map<String,Object> errorMessage = new HashMap<String,Object>();

                errorMessage.put("message",ex.getMessage());
                errorMessage.put("code", HttpStatus.UNAUTHORIZED);
                error.put("error",errorMessage);
                res.put("data",error);
                res.put("success",false);

                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json");
                ObjectMapper objectMapper = new ObjectMapper();
                response.getWriter().write(objectMapper.writeValueAsString(res));
                return;
            }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest httpServletRequest) throws ServletException{
        String path = httpServletRequest.getServletPath();
        return path.startsWith("/v1/auth/") || path.equals("/v1/auth/register") || path.equals("/v1/auth/sign-in");
    }
}
