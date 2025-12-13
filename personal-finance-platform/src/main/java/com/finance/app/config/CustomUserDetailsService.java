package com.finance.app.config;

import com.finance.app.entity.User;
import com.finance.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//this connect spring security to database
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

   private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
      User user = userRepository.findByEmail(email)
              .orElseThrow(()->new UsernameNotFoundException("User not found"));

      return new CustomUserDetails(user);
    }
}
