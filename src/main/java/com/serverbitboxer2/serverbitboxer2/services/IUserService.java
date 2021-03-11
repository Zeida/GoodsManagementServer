package com.serverbitboxer2.serverbitboxer2.services;

import com.serverbitboxer2.serverbitboxer2.dto.UserDTO;

import java.util.List;

public interface IUserService {
    List<UserDTO> findAll();
    List<UserDTO> findUsersByName(String name);
    UserDTO findUserByCode(Long userCode);
    void createUser(UserDTO userDTO);
    void deleteUser(Long userCode);
}
