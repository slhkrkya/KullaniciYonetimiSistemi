package com.example.hafta2_lab2.service;

import com.example.hafta2_lab2.DTO.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    void deleteUser(Long id);
    void updateUser(UserDTO userDTO);
}
