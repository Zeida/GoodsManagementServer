package com.serverbitboxer2.serverbitboxer2.assembler;

import com.serverbitboxer2.serverbitboxer2.dto.UserDTO;
import com.serverbitboxer2.serverbitboxer2.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserAssembler {
    private final ModelMapper modelMapper = new ModelMapper();

    public UserDTO entity2DTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User DTO2Entity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
