package com.expense_tracker.service;

import com.expense_tracker.dto.UserDTO;
import com.expense_tracker.model.User;
import com.expense_tracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(UserDTO userDTO){
        User user = convertToEntity(userDTO);
        User savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }

    public List<UserDTO> getAllUser(){
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToDTO)
                .toList();
    }

    public void removeUser(Long userId){
        userRepository.deleteById(userId);
    }

    public UserDTO updateUser(UserDTO userDTO, Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found!"));
        user.setEmail(userDTO.getEmail());
        System.out.println(user);
        User updatedUser = userRepository.save(user);
        return convertToDTO(updatedUser);
    }

    public Optional<UserDTO> findUserById(Long id){
        return userRepository.findById(id).map(this::convertToDTO);
    }

    public UserDTO convertToDTO(User user){
        return new UserDTO(
                user.getId(),
                user.getEmail()
        );
    }
    public User convertToEntity(UserDTO userDTO){
        return new User(
                userDTO.getId(),
                userDTO.getEmail()
        );
    }
}
