package com.serverbitboxer2.serverbitboxer2.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="supplier")
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Supplier{" +
                "suppliercode=" + suppliercode +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer supplierid;
    private Long suppliercode;
    private String name;
    private String country;

    @ManyToMany(mappedBy = "suppliers")
    private List<Item> itemssupplied;

    public Long getSuppliercode() {
        return suppliercode;
    }

    public Supplier(){}
    public Supplier(Integer supplierid, Long suppliercode, String name, String country, List<Item> itemssupplied) {
        this.supplierid = supplierid;
        this.suppliercode = suppliercode;
        this.name = name;
        this.country = country;
        this.itemssupplied = itemssupplied;
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

    public List<Item> getItemssupplied() {
        return itemssupplied;
    }

    public void setItemssupplied(List<Item> itemssupplied) {
        this.itemssupplied = itemssupplied;
    }


}
