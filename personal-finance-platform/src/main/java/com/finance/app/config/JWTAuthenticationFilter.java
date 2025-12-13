package com.finance.app.config;

import com.finance.app.util.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import org.springframework.http.HttpHeaders;

//It is a Spring Security filter that runs once per request to check authentication.
@Component
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {

          private final JwtUtil jwtUtil;
          private final CustomUserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        //1. No token -> continue (public endpoints)
        if(authHeader==null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }

        String token = authHeader.substring(7);


        //2.Validate token
        if(!jwtUtil.isTokenValid(token)){
            filterChain.doFilter(request,response);
        }

        //3.Extract email
        Claims claims = jwtUtil.extractAllClaims(token);
        String email = claims.getSubject();


        //4.Authenticate only if not already authenticated
        if(email!=null && SecurityContextHolder.getContext().getAuthentication() ==null) {
            CustomUserDetails userDetails =
                    (CustomUserDetails) userDetailsService.loadUserByUsername(email);

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.getAuthorities()
            );

            authentication.setDetails(new WebAuthenticationDetailsSource()
                    .buildDetails(request));


            //5. SET authentication in security context
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // request.setAttribute("email", claims.getSubject());

        }
        filterChain.doFilter(request,response);
    }
}
