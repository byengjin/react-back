package com.org.customermanagement.security.jwt;

import com.org.customermanagement.security.UserPrinciple;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

public interface JwtProvider {
    String generateToken(UserPrinciple auth);
    Authentication getAuthentication(HttpServletRequest request);
    boolean isTokenValid(HttpServletRequest request);
}
