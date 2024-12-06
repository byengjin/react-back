package com.org.customermanagement.service;

import com.org.customermanagement.model.User;

public interface AuthenticationService {
    public User signInAndReturnJWT(User signInRequest);
}

