package com.serverbitboxer2.serverbitboxer2.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SupplierService implements ISupplierService{
    @PersistenceContext
    private EntityManager entityManager;

}
