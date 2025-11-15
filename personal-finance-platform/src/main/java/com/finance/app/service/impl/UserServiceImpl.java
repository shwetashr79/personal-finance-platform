package com.finance.app.service.impl;

import com.finance.app.dto.LoginRequest;
import com.finance.app.dto.RegisterRequest;
import com.finance.app.entity.User;
import com.finance.app.repository.UserRepository;
import com.finance.app.service.UserService;
import com.finance.app.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final JwtUtil jwtUtil;

    //encrypts(hashes) the user's pswd before saving it to the db
    //industry standard for secure password storage
    //comes from spring security
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public String register(RegisterRequest request) {
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            return "Email already exists";
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);

        return "User registered successfully!";
    }

    @Override
    public String login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElse(null);

        if(user==null || !passwordEncoder.matches(request.getPassword(), user.getPassword())){
            return "Invalid email or password";
        }
        return jwtUtil.generateToken(user.getEmail());
    }
}
