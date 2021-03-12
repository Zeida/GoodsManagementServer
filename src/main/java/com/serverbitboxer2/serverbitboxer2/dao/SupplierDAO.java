package com.serverbitboxer2.serverbitboxer2.dao;

import com.serverbitboxer2.serverbitboxer2.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplierDAO extends JpaRepository<Supplier, Long> {

    Optional<Supplier> findBySuppliercode(Long suppliercode);

    void deleteBySuppliercode(Long suppliercode);
}
