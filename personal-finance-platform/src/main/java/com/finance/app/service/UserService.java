package com.finance.app.service;


import com.finance.app.dto.LoginRequest;
import com.finance.app.dto.RegisterRequest;

public interface UserService {
    String register(RegisterRequest request);
    String login(LoginRequest request);
}
