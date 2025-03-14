package com.expense_tracker.controller;

import com.expense_tracker.dto.UserDTO;
import com.expense_tracker.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @GetMapping("/{id}")
    public Optional<UserDTO> getUser(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @PostMapping("/update/{id}")
    public UserDTO updateUser(@RequestBody UserDTO userDTO, @PathVariable Long id){
        return userService.updateUser(userDTO, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.removeUser(id);
    }

    @GetMapping("/")
    public List<UserDTO> getAllUser(){
        return userService.getAllUser();
    }


}
