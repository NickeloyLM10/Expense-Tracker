package com.expense_tracker.controller;

import com.expense_tracker.dto.UserDTO;
import com.expense_tracker.service.AuthenticationService;
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

    @GetMapping("/{id}")
    public Optional<UserDTO> getUser(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @PostMapping("/update")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO, userDTO.id());
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
