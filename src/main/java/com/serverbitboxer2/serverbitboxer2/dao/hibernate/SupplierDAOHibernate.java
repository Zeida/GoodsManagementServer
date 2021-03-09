package com.serverbitboxer2.serverbitboxer2.dao.hibernate;

import com.serverbitboxer2.serverbitboxer2.dao.SupplierDAO;
import com.serverbitboxer2.serverbitboxer2.entities.Supplier;

import java.util.Optional;

public class SupplierDAOHibernate implements SupplierDAO {
    @Override
    public <S extends Supplier> S save(S s) {
        return null;
    }

    @Override
    public <S extends Supplier> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Supplier> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Supplier> findAll() {
        return null;
    }

    @Override
    public Iterable<Supplier> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Supplier supplier) {

    }

    @Override
    public void deleteAll(Iterable<? extends Supplier> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
