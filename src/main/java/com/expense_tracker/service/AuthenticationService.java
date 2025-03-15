package com.expense_tracker.service;

import com.expense_tracker.dto.UserDTO;
import com.expense_tracker.model.User;
import com.expense_tracker.repository.UserRepository;
import com.expense_tracker.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public UserDTO registerUser(UserDTO userDTO){
        User user = new User(null, userDTO.email(), passwordEncoder.encode(userDTO.password()));
        User savedUser = userRepository.save(user);
        return new UserDTO(savedUser.getId(), savedUser.getEmail(), null);
    }

    public String authenticateUser(String email, String password){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
        User user = userRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("User not found!"));

        return jwtUtil.generateToken(user.getEmail());
    }
}
