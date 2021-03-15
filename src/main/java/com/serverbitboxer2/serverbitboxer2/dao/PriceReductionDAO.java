package com.serverbitboxer2.serverbitboxer2.dao;

import com.serverbitboxer2.serverbitboxer2.entities.PriceReduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriceReductionDAO extends JpaRepository<PriceReduction, Long> {
    Optional<PriceReduction> findByPricereductioncode(String priceReductionCode);

    void deleteByPricereductioncode(String priceReductionCode);
}
