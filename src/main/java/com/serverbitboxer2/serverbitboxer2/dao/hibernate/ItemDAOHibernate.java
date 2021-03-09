package com.serverbitboxer2.serverbitboxer2.dao.hibernate;

import com.serverbitboxer2.serverbitboxer2.dao.ItemDAO;
import com.serverbitboxer2.serverbitboxer2.entities.Item;

import java.util.List;
import java.util.Optional;

public class ItemDAOHibernate implements ItemDAO {

    @Override
    public <S extends Item> S save(S s) {
        return null;
    }

    @Override
    public <S extends Item> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Item> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Item> findAll() {
        return null;
    }

    @Override
    public Iterable<Item> findAllById(Iterable<Long> iterable) {
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
    public void delete(Item item) {

    }

    @Override
    public void deleteAll(Iterable<? extends Item> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
