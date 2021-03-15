package com.serverbitboxer2.serverbitboxer2.services;

import com.serverbitboxer2.serverbitboxer2.assembler.ItemAssembler;
import com.serverbitboxer2.serverbitboxer2.assembler.UserAssembler;
import com.serverbitboxer2.serverbitboxer2.dao.ItemDAO;
import com.serverbitboxer2.serverbitboxer2.dao.UserDAO;
import com.serverbitboxer2.serverbitboxer2.dto.UserDTO;
import com.serverbitboxer2.serverbitboxer2.entities.User;
import com.serverbitboxer2.serverbitboxer2.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements IUserService{

    @PersistenceContext
    private EntityManager entityManager;

    //Repositories
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ItemDAO itemDAO;

    //Assemblers
    private UserAssembler userAssembler = new UserAssembler();
    private ItemAssembler itemAssembler = new ItemAssembler();


    @Override
    public List<UserDTO> findAll() {
        List<User> users = userDAO.findAll();
        List<UserDTO> usersDTO = new ArrayList<>();
        for(User user: users){
            usersDTO.add(userAssembler.entity2DTO(user));
        }
        return usersDTO;
    }

    @Override
    public List<UserDTO> findByName(String name) {
        List<User> users = userDAO.findAllByName(name);
        List<UserDTO> usersDTO = new ArrayList<>();
        for(User user: users){
            usersDTO.add(userAssembler.entity2DTO(user));
        }
        return usersDTO;
    }

    @Override
    public UserDTO findByUsercode(String usercode ) {
        Optional<User> user = userDAO.findByUsercode(usercode);
        if(user.isPresent()){
            return (userAssembler.entity2DTO(user.get()));
        }else throw new ResourceNotFoundException("The User with the code: " + usercode + "does not exist");

    }

    @Override
    public void createUser(UserDTO userDTO) {
        userDAO.save(userAssembler.DTO2Entity(userDTO));
    }

    @Override
    public void deleteUser(String userCode) {
        userDAO.deleteByUsercode(userCode);
    }

}
