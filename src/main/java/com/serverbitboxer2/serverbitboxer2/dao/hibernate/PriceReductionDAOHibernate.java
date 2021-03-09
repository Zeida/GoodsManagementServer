package com.serverbitboxer2.serverbitboxer2.dao.hibernate;

import com.serverbitboxer2.serverbitboxer2.dao.PriceReductionDAO;
import com.serverbitboxer2.serverbitboxer2.entities.PriceReduction;

import java.util.Optional;

public class PriceReductionDAOHibernate implements PriceReductionDAO {
    @Override
    public <S extends PriceReduction> S save(S s) {
        return null;
    }

    @Override
    public <S extends PriceReduction> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<PriceReduction> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<PriceReduction> findAll() {
        return null;
    }

    @Override
    public Iterable<PriceReduction> findAllById(Iterable<Long> iterable) {
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
    public void delete(PriceReduction priceReduction) {

    }

    @Override
    public void deleteAll(Iterable<? extends PriceReduction> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
