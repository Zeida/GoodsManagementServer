package com.serverbitboxer2.serverbitboxer2.services;

import com.serverbitboxer2.serverbitboxer2.dto.UserDTO;

import java.util.List;

public interface IUserService {
    List<UserDTO> findAll();
    List<UserDTO> findByName(String name);
    UserDTO findByUsercode(String userCode);
    UserDTO findByUsername(String username);
    void createUser(UserDTO userDTO);
    void deleteUser(String userCode);
}
