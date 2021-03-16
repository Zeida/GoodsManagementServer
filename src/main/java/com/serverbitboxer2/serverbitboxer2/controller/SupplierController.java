package com.serverbitboxer2.serverbitboxer2.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverbitboxer2.serverbitboxer2.dto.SupplierDTO;
import com.serverbitboxer2.serverbitboxer2.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SupplierController {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    SupplierService supplierService;

    @GetMapping("/suppliers")
    public List<SupplierDTO> findAll() {
        return supplierService.findAll();
    }

    @GetMapping("/supplier/{suppliercode}")
    public SupplierDTO findBySuppliercode(@PathVariable(name = "suppliercode") String suppliercode) {
        SupplierDTO supplierDTO = supplierService.findBySuppliercode(suppliercode);
        if (supplierDTO == null) {
            throw new RuntimeException("The Supplier with code: " + suppliercode + " does not exist");
        }
        return supplierDTO;
    }

    @PostMapping(value = "/supplier/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SupplierDTO> createSupplier(@RequestBody String supplier) throws JsonProcessingException {
        SupplierDTO supplierDTO = objectMapper.readValue(supplier, SupplierDTO.class);
        supplierService.createSupplier(supplierDTO);
        return ResponseEntity.ok().body(supplierDTO);
    }

    @DeleteMapping("/supplier/{suppliercode}/delete")
    public ResponseEntity<Void> deleteSupplier(@PathVariable(name = "suppliercode") String suppliercode) {
        SupplierDTO supplierDTO = supplierService.findBySuppliercode(suppliercode);
        if (supplierDTO == null) {
            throw new RuntimeException("The Supplier with code: " + suppliercode + " does not exist");
        }
        supplierService.deleteSupplier(suppliercode);
        return ResponseEntity.ok().build();
    }
}
