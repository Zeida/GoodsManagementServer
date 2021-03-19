package com.serverbitboxer2.serverbitboxer2.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverbitboxer2.serverbitboxer2.dto.UserDTO;
import com.serverbitboxer2.serverbitboxer2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @GetMapping("/users")
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/user/name/{name}")
    public List<UserDTO> findUsersByName(@PathVariable(name = "name") String name) {
        return userService.findByName(name);
    }

    @GetMapping("/user/usercode/{usercode}")
    public UserDTO findUserByCode(@PathVariable(name = "usercode") String usercode) {
        UserDTO userDTO = userService.findByUsercode(usercode);
        if (userDTO == null) {
            throw new RuntimeException("The User with code: " + usercode + " does not exist");
        }
        return userDTO;
    }

    @GetMapping("/user/username/{username}")
    public UserDTO findByUsername(@PathVariable(name = "username") String username) {
        UserDTO userDTO = userService.findByUsername(username);
        if (userDTO == null) {
            throw new RuntimeException("The User with username: " + username + " does not exist");
        }
        return userDTO;
    }
    //se deberia usar este método para el register
    @PostMapping(value = "/user/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> createUser(@RequestBody String user) throws JsonProcessingException {
        UserDTO userDTO = objectMapper.readValue(user, UserDTO.class);
        String salt = BCrypt.gensalt(12);
        userDTO.setPassword(BCrypt.hashpw(userDTO.getPassword(), salt));
        userService.createUser(userDTO);
        return ResponseEntity.ok().body(userDTO);
    }

    @DeleteMapping("/user/{usercode}/delete")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "usercode") String usercode) {
        UserDTO userDTO = userService.findByUsercode(usercode);
        if (userDTO == null) {
            throw new RuntimeException("The User with code: " + usercode + " does not exist");
        }
        userService.deleteUser(usercode);
        return ResponseEntity.ok().build();
    }
}
