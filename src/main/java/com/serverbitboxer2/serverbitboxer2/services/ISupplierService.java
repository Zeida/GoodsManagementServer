package com.serverbitboxer2.serverbitboxer2.services;

import com.serverbitboxer2.serverbitboxer2.dto.SupplierDTO;

import java.util.List;

public interface ISupplierService {
    List<SupplierDTO> findAll();
    SupplierDTO findBySuppliercode(Long suppliercode);
    void createSupplier(SupplierDTO supplierDTO);
    void deleteSupplier(Long suppliercode);
}
