package com.serverbitboxer2.serverbitboxer2.dao;

import com.serverbitboxer2.serverbitboxer2.dto.UserDTO;
import com.serverbitboxer2.serverbitboxer2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    UserDTO findByUsercode(Long usercode);
    void deleteByUsercode(Long userCode);
    List<User> findAllByName(String name);
}
