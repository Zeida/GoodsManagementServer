package com.serverbitboxer2.serverbitboxer2.dto;

import com.serverbitboxer2.serverbitboxer2.entities.Item;

import java.util.List;

public class SupplierDTO {

    private Long suppliercode;
    private String name;
    private String country;
    private List<ItemDTO> itemssupplied;

    public List<ItemDTO> getItemssupplied() {
        return itemssupplied;
    }

    public void setItemssupplied(List<ItemDTO> itemssupplied) {
        this.itemssupplied = itemssupplied;
    }

    public Long getSuppliercode() {
        return suppliercode;
    }

    public void setSuppliercode(Long suppliercode) {
        this.suppliercode = suppliercode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
