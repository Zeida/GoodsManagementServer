package com.serverbitboxer2.serverbitboxer2.services;

import com.serverbitboxer2.serverbitboxer2.assembler.SupplierAssembler;
import com.serverbitboxer2.serverbitboxer2.dao.SupplierDAO;
import com.serverbitboxer2.serverbitboxer2.dto.SupplierDTO;
import com.serverbitboxer2.serverbitboxer2.entities.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierService implements ISupplierService{
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private SupplierDAO supplierDAO;

    private SupplierAssembler supplierAssembler;

    @Override
    public List<SupplierDTO> findAll() {
        List<SupplierDTO> suppliersDTO = new ArrayList<>();
        List<Supplier> suppliers = supplierDAO.findAll();
        for (Supplier supplier:suppliers) {
            suppliersDTO.add(supplierAssembler.entity2DTO(supplier));
        }
        return suppliersDTO;
    }

    @Override
    public SupplierDTO findBySuppliercode(Long suppliercode) {
        return supplierDAO.findBySuppliercode(suppliercode);
    }

    @Override
    public void createSupplier(SupplierDTO supplierDTO) {
        supplierDAO.save(supplierAssembler.DTO2Entity(supplierDTO));

    }

    @Override
    public void deleteSupplier(Long suppliercode) {
        supplierDAO.deleteBySuppliercode(suppliercode);
    }
}
