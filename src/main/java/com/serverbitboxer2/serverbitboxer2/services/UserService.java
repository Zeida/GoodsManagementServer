package com.serverbitboxer2.serverbitboxer2.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserService implements IUserService{

    @PersistenceContext
    private EntityManager entityManager;

}
