package com.serverbitboxer2.serverbitboxer2.services;

import com.serverbitboxer2.serverbitboxer2.assembler.ItemAssembler;
import com.serverbitboxer2.serverbitboxer2.assembler.UserAssembler;
import com.serverbitboxer2.serverbitboxer2.dao.ItemDAO;
import com.serverbitboxer2.serverbitboxer2.dao.UserDAO;
import com.serverbitboxer2.serverbitboxer2.dto.UserDTO;
import com.serverbitboxer2.serverbitboxer2.entities.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService{

    @PersistenceContext
    private EntityManager entityManager;

    //Repositories
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ItemDAO itemDAO;

    //Assemblers
    private UserAssembler userAssembler;
    private ItemAssembler itemAssembler;


    @Override
    public List<UserDTO> findAllUsers() {
        List<User> users = userDAO.findAll();
        List<UserDTO> usersDTO = new ArrayList<>();
        for(User user: users){
            usersDTO.add(userAssembler.entity2DTO(user));
        }
        return usersDTO;
    }

    @Override
    public List<UserDTO> findUsersByName(String name) {
        List<User> users = userDAO.findAllByName(name);
        List<UserDTO> usersDTO = new ArrayList<>();
        //Gestionar qué ocurre cuando no hay usuarios con ese nombre
        for(User user: users){
            usersDTO.add(userAssembler.entity2DTO(user));
        }
        return usersDTO;
    }

    @Override
    public UserDTO findUserByCode(Long userCode ) {
        return userDAO.findByUsercode(userCode);
    }

    @Override
    public void createUser(UserDTO userDTO) {
        userDAO.save(userAssembler.DTO2Entity(userDTO));
    }

    @Override
    public void deleteUser(Long userCode) {
        userDAO.deleteByUsercode(userCode);

    }

}
