package com.serverbitboxer2.serverbitboxer2.dao;

import com.serverbitboxer2.serverbitboxer2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    User findByUsercode(Integer usercode);
}
