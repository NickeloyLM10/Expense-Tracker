package com.expense_tracker.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService userDetailsService;

    public JwtAuthFilter(JwtUtil jwtUtil, CustomUserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
//        System.out.println("Token in request: " + authHeader);
        String token = null;
        String userEmail = null;

        if(authHeader != null && authHeader.startsWith("Bearer ")){
            token = authHeader.split(" ")[1].trim();
            userEmail = jwtUtil.extractUserName(token);
        }

        if(userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){
            var userDetails = userDetailsService.loadUserByUsername(userEmail);

            if(jwtUtil.isTokenValid(token, userDetails.getUsername())){
                var authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        System.out.println("Token: " + token);
        System.out.println("User from Token: " + userEmail);

        filterChain.doFilter(request,response);

    }
}
