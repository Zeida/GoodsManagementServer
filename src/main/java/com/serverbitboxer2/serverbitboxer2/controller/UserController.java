package com.serverbitboxer2.serverbitboxer2.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverbitboxer2.serverbitboxer2.dto.UserDTO;
import com.serverbitboxer2.serverbitboxer2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;
    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/users")
    public List<UserDTO> findAll() {
        return userService.findAll();
    }
    @GetMapping("/user/name/{name}")
    public List<UserDTO> findUsersByName(@PathVariable(name = "name") String name) {
        return userService.findByName(name);
    }
    @GetMapping("/user/{usercode}")
    public UserDTO findUserByCode(@PathVariable(name = "usercode") Long usercode) {
        UserDTO userDTO = userService.findByUsercode(usercode);
        if(userDTO==null){
            throw new RuntimeException("The User with code: "+ usercode +" does not exist");
        }
        return userDTO;
    }
    @PostMapping(value="/user/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody String user) throws JsonProcessingException {
        UserDTO userDTO = objectMapper.readValue(user, UserDTO.class);
        userService.createUser(userDTO);
    }

    @DeleteMapping("/user/{usercode}/delete")
    public void deleteUser(@PathVariable(name = "usercode") Long usercode) {
        UserDTO userDTO = userService.findByUsercode(usercode);
        if(userDTO==null){
            throw new RuntimeException("The User with code: "+ usercode +" does not exist");
        }
        userService.deleteUser(usercode);
    }
}
