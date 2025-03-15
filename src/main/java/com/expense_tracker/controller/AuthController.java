package com.expense_tracker.controller;

import com.expense_tracker.dto.UserDTO;
import com.expense_tracker.service.AuthenticationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody UserDTO userDTO){
        return authenticationService.registerUser(userDTO);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO){
        return authenticationService.authenticateUser(userDTO.email(), userDTO.password());
    }
}
